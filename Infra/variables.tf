# ---------------------------- Service Princial  ----------------------------

variable "aks_service_principal_app_id" {
  type          = string
  description   = "Service Principal appId"
}

variable "aks_service_principal_client_secret" {
  type          = string
  description   = "Service Principal password"
}

# ---------------------------- Resrouce Group  ----------------------------

variable "resource_group_name" {
  type        = string
  description = "RG name in Azure"
}

variable "location" {
  type        = string
  description = "Resources location in Azure"
}

# ---------------------------- Azure Container Registry  ----------------------------

variable "acr_name" {
  type        = string
  description = "ACR name"
}

# ---------------------------- Azure Kubernetes Service  ----------------------------

variable "cluster_name" {
  type        = string
  description = "AKS name in Azure"
}

variable "kubernetes_version" {
  type        = string
  description = "Kubernetes version"
}

variable "system_node_count" {
  type        = number
  description = "Number of AKS worker nodes"
}

# ---------------------------- Networking  ----------------------------

variable "role_definition_name" {
  type        = string
  description = "Role Definition Name"
}

variable "static_ip_name" {
  type        = string
  description = "Static IP Name"
}

# ---------------------------- Cosmos DB  ----------------------------

variable "cosmos_db_account_name" {
  type        = string
  description = "Dynamo DB name in Azure"
}

# ---------------------------- Azure Service Bus ----------------------------

variable "servicebus_namespace_name" {
  type        = string
  description = "Service Bus namespace in Azure"
}