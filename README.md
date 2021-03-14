# rbd-azure-spring-aks

<h1>Demo project of using AKS and other Azure services with Spring Boot</h1> 

<p align="center">
  <img src="http://img.shields.io/static/v1?label=License&message=MIT&color=green&style=for-the-badge"/>
  <img src="http://img.shields.io/static/v1?label=Java&message=11&color=red&style=for-the-badge"/>
</p>

### Topics 

:small_blue_diamond: [Project Description](#project-description)

:small_blue_diamond: [Functionalities](#functionalities)

:small_blue_diamond: [Pre-requisites](#pre-requisites)

:small_blue_diamond: [How to Deploy the Application](#how-to-deploy-the-application)

:small_blue_diamond: [How to run the application](#how-to-run-the-application)

:small_blue_diamond: [How to run the tests](#how-to-run-the-tests)

:small_blue_diamond: [Used programming languages, dependencies and libs](#used-programming-languages-dependencies-and-libs)

:small_blue_diamond: [License](#license)


## Project Description

<p align="justify">
  Demo project of using AKS and other Azure services with Spring Boot
</p>

## Functionalities

:heavy_check_mark: Expose an endpoint to receive REST calls (GET, POST, DELETE)

:heavy_check_mark: Manage data in Cosmos DB (Insert, Search and Delete)

:heavy_check_mark: Send messages to a Service Bus queue 

:heavy_check_mark: Receive messages from a Service Bus queue

## Pre-requisites

- Have an Azure Subscription
- Have Java 11 installed on the development machine [Java 11 Download](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- Have Azure CLI installed on the development machine [Azure CLI Download](https://docs.microsoft.com/en-us/cli/azure/install-azure-cli)
- Have Docker installed on the development machine [Docker for Windows Download](https://docs.docker.com/docker-for-windows/install/)
- Have Terraform installed on the development machine [Terraform Download](https://www.terraform.io/downloads.html)
- Have Postman installed on the development machine to call the APIs [Postman Download](https://www.postman.com/downloads/?offset=555&source=user_profile---------------------------&__hstc=259582869.af2722f551416309ba90cfe76382e225.1560827015470.1560827015470.1560827015470.1&__hssc=259582869.10.1560827015474&__hsfp=2972645620&hubs_post=blog.hubspot.com/website/author/anna-fitzgerald/page/12&hubs_post-cta=Contact%20Us&limit=15)

## How to Deploy the Application:

### Deploy the Azure Infrastructure

1. Login into to your Azure Subscription by using Azure CLI:

```
az login
```

2. Select the subscription that is going to be used to deploy the application:

```
az account set --subscription <subscription_name>
```

3. In the "Infra" folder, initiate Terraform:

```
terraform init
```

4. Preview the resources that will be created: 

```
terraform plan -out=<plan_name>
```

5. Execute the plan to deploy the resources

```
terraform apply <plan_name>
```

PS. It is recomened the creation of a file called: terraform.tfvars to specify all the variables needed to create the enviroment. This variables are defined on the "Infra\variables.tf" file.

### Deploy the application

1. Build the docker image to be deployed

```
docker build  -t <image_name> <path to docker file>
```

2. Tag the this image with the target Azure Container Registry

```
docker tag <source_image>:<tag> <targe_image>:<tag> 
```
Note: Target image: \<acr_name>.azurecr.io/\<image name>:<tag>

3. Login in to the Azure Container Registry (ACR) using Azure CLI:
```
az acr login --name <acr_name>
```
4. Push the tagged image to ACR:
```
docker push <image_name>:<tag>
```
5. Get Azure Kubernetes Serivce (AKS) credentials using Azure CLI:
```
az acr login --name <acrName>
```
az aks get-credentials --resource-group <resource_group_name> --name <aks_cluster_name>

6. Deploy application configuration
```
kubectl apply -f <file>.yaml
```
Note: Update the file Infra Config\azure_demo with the name of the ACR and the version of the image


## How to run the application :arrow_forward:

In order to run the application against Azure infrastructure, it is necessary to get the IP tht is being used by the Load Balancer in the Kubernetes Cluster. To get this information, run the following command:

```
kubectl get service <service-name> --watch
```

The APIs that can be called are defined in the Application\swagger.json file and the Postman collection at Postman\Azure Demo.postman_collection with the environment variables at Postman\Local Environment.postman_environment

## How to run the tests

**To be written**

## Used programming languages, dependencies and libs

- [Terraform](https://www.terraform.io/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Azure Service Bus](https://docs.microsoft.com/en-us/azure/service-bus-messaging/)
- [Azure Cosmos DB](https://docs.microsoft.com/en-us/azure/cosmos-db/introduction)
- [Azure Kubernetes Service](https://docs.microsoft.com/en-us/azure/aks/)

## License 

The [MIT License]() (MIT)
