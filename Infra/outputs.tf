# ---------------------------- Azure Kubernetes Service  ----------------------------

output "aks_id" {
  value = azurerm_kubernetes_cluster.aks.id
}

output "aks_fqdn" {
  value = azurerm_kubernetes_cluster.aks.fqdn
}

output "aks_node_rg" {
  value = azurerm_kubernetes_cluster.aks.node_resource_group
}

output "acr_id" {
  value = azurerm_container_registry.acr.id
}

output "acr_login_server" {
  value = azurerm_container_registry.acr.login_server
}

# ---------------------------- Networking  ----------------------------

output "static_ip" {
  value = azurerm_public_ip.aks_ip.ip_address
}

# ---------------------------- Cosmos DB  ----------------------------

output "azure_cosmosdb_uri" {
  value = azurerm_cosmosdb_account.acc.endpoint
}

output "azure_cosmosdb_key" {
  value = azurerm_cosmosdb_account.acc.primary_key
}

# ---------------------------- Azure Service Bus ----------------------------

output "sb_connection_string" {
  value = azurerm_servicebus_namespace.sb_namespace.default_primary_connection_string
}

# ---------------------------- Monitoring ----------------------------

output "app_in_connection_string" {
  value = azurerm_application_insights.app_insights.connection_string
}