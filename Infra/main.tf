# ---------------------------- Resource Group  ----------------------------

resource "azurerm_resource_group" "rg" {
  name     = var.resource_group_name
  location = var.location
}

# ---------------------------- Azure Container Registry  ----------------------------

resource "azurerm_role_assignment" "role_acrpull" {
  scope                            = azurerm_container_registry.acr.id
  role_definition_name             = "AcrPull"
  principal_id                      = var.aks_service_principal_app_id
  skip_service_principal_aad_check = true
}

resource "azurerm_container_registry" "acr" {
  name                = var.acr_name
  resource_group_name = azurerm_resource_group.rg.name
  location            = var.location
  sku                 = "Standard"
  admin_enabled       = false
}

# ---------------------------- Azure Kubernetes Service  ----------------------------

resource "azurerm_kubernetes_cluster" "aks" {
  name                = var.cluster_name
  kubernetes_version  = var.kubernetes_version
  location            = var.location
  resource_group_name = azurerm_resource_group.rg.name
  dns_prefix          = var.cluster_name

  default_node_pool {
    name                = "system"
    node_count          = var.system_node_count
    vm_size             = "Standard_DS2_v2"
    type                = "VirtualMachineScaleSets"
    #availability_zones  = [1, 2, 3]
    enable_auto_scaling = false
  }

  service_principal {
    client_id     = var.aks_service_principal_app_id
    client_secret = var.aks_service_principal_client_secret
  }

  network_profile {
    network_plugin    = "kubenet" # CNI
    load_balancer_sku = "Standard"
  }
}

# ---------------------------- Networking  ----------------------------

resource "azurerm_public_ip" "aks_ip" {
  name                          = var.static_ip_name
  location                      = azurerm_resource_group.rg.location
  resource_group_name           = azurerm_resource_group.rg.name
  allocation_method             = "Static"
  sku                           = "Standard"
}

resource "azurerm_role_assignment" "aks_ip_rg" {
  scope                             = azurerm_public_ip.aks_ip.id
  role_definition_name              = "Contributor"
  principal_id                      = var.aks_service_principal_app_id
  skip_service_principal_aad_check  = true
}

# ---------------------------- Cosmos DB  ----------------------------

resource "azurerm_cosmosdb_account" "acc" {
  name                      = var.cosmos_db_account_name
  location                  = azurerm_resource_group.rg.location
  resource_group_name       = azurerm_resource_group.rg.name
  offer_type                = "Standard"
  kind                      = "GlobalDocumentDB"
  enable_automatic_failover = false

consistency_policy {
    consistency_level = "Session"
  }

geo_location {
    location            = azurerm_resource_group.rg.location
    failover_priority   = 0
  }
}

# ---------------------------- Databases ----------------------------

resource "azurerm_cosmosdb_sql_database" "diseasesdb" {
  name                  = "diseases"
  resource_group_name   = azurerm_cosmosdb_account.acc.resource_group_name
  account_name          = azurerm_cosmosdb_account.acc.name
}

# ---------------------------- Azure Service Bus ----------------------------

resource "azurerm_servicebus_namespace" "sb_namespace" {
  name                = var.servicebus_namespace_name
  location            = azurerm_resource_group.rg.location
  resource_group_name = azurerm_resource_group.rg.name
  sku                 = "Standard"

  tags = {
    source = "terraform"
  }
}

resource "azurerm_servicebus_queue" "sb_queue1" {
  name                = "queue1"
  resource_group_name = azurerm_resource_group.rg.name
  namespace_name      = azurerm_servicebus_namespace.sb_namespace.name

  enable_partitioning = true
}