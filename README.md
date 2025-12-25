# E-Commerce Microservices Project

This project demonstrates a microservices architecture using Spring Boot and Spring Cloud. It consists of several services working together to provide e-commerce functionality.

## Architecture

The project is composed of the following microservices:

*   **Config Service**: Centralized configuration server backed by a Git repository.
*   **Discovery Service**: Eureka Service Registry for service discovery.
*   **Gateway Service**: Spring Cloud Gateway for routing and load balancing.
*   **Customer Service**: Manages customer data and configuration testing.
*   **Inventory Service**: Manages product inventory.
*   **Billing Service**: Handles billing and invoices.

## Services Overview

### 1. Discovery Service (Eureka)
The Eureka server acts as a service registry. All other services register themselves here.

<img width="1340" height="905" alt="eureka-discovery" src="https://github.com/user-attachments/assets/7ff942e8-9866-4cf3-9f1c-0c56309c0e04" />


### 2. Config Service
Provides configuration to all other services. It fetches configuration from a Git repository.

**Example Response:**

<img width="1343" height="902" alt="config-service" src="https://github.com/user-attachments/assets/e9400f08-c892-494e-b5ec-2ad624896027" />

### 3. Customer Service
A RESTful service for managing customers. It uses H2 database and exposes endpoints via Spring Data REST.

**API Response:**

<img width="1343" height="904" alt="discovery-customer" src="https://github.com/user-attachments/assets/964c98da-7c83-4042-a886-f816b9333d4b" />

**H2 Console:**

<img width="1512" height="863" alt="customer-db" src="https://github.com/user-attachments/assets/e6e9da72-ed90-4649-9b70-c5189dc4d38b" />

### 4. Billing Service
Manages bills and product items.

**API Response:**

<img width="1343" height="902" alt="billing-service" src="https://github.com/user-attachments/assets/3d96c22e-1262-4f1b-bb94-43470150ec46" />

## Technologies Used

*   **Java 17**
*   **Spring Boot 3.x**
*   **Spring Cloud 2023.x**
*   **Spring Cloud Config**
*   **Spring Cloud Netflix Eureka**
*   **Spring Cloud Gateway**
*   **Spring Data JPA**
*   **Spring Data REST**
*   **H2 Database**
*   **Lombok**
*   **OpenFeign**

## How to Run

1.  **Start Config Service**: Run `ConfigServiceApplication` (Port 9999).
2.  **Start Discovery Service**: Run `DiscoveryServiceApplication` (Port 8761).
3.  **Start Gateway Service**: Run `GatewayServiceApplication` (Port 8888).
4.  **Start Microservices**:
    *   `CustomerServiceApplication` (Port 8081)
    *   `InventoryServiceApplication` (Port 8082)
    *   `BillingServiceApplication` (Port 8083)

Ensure all services are up and registered in the Eureka Dashboard at `http://localhost:8761`.

## Configuration

The configuration for all services is stored in the `config-repo` directory (or the configured Git repository).
