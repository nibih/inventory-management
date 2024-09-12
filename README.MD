# Inventory Management System

This project is a backend API for an Inventory Management System built using Spring Boot, Java, and PostgreSQL. It provides RESTful endpoints to manage inventory items with CRUD (Create, Read, Update, Delete) operations, using DTOs and a JSONB field for flexible data storage.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Running the Application](#running-the-application)
- [Logging](#logging)
- [Future Enhancements](#future-enhancements)

## Features

- Create, retrieve, update, and delete inventory items.
- Store dynamic structured data using JSONB.
- Validate image uploads to only accept JPG and PNG formats.
- Logging of requests and responses using Log4j2.
- Use of Lombok to reduce boilerplate code.

## Technologies Used

- **Java 11**
- **Spring Boot 2.7.x**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Log4j2**

## Getting Started

### Prerequisites

- **Java 11** or higher installed.
- **Maven** installed.
- **PostgreSQL** installed and running.

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/inventory-management.git
   cd inventory-management

   ```

2. **Configure PostgreSQL Database:** Create a PostgreSQL database named `inventory_db` (or any name you prefer) and update the `src/main/resources/application.properties` file with your PostgreSQL credentials.

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/inventory_db
   spring.datasource.username=your_db_username
   spring.datasource.password=your_db_password

   ```

3. **Build and run the application:**

   ```bash
    mvn clean install

   ```

   ```bash
    mvn spring-boot:run

   ```

4. **Access the API:** The API will be available at `http://localhost:8080/api/items`.

## Project Structure

```bash

inventory-management/
├── src/
│ ├── main/
│ │ ├── java/com/example/inventorymanagement/
│ │ │ ├── controller/ # REST Controllers
│ │ │ ├── dto/ # Data Transfer Objects (DTO)
│ │ │ ├── model/ # JPA Entities
│ │ │ ├── repository/ # Spring Data JPA Repositories
│ │ │ ├── service/ # Service Interfaces
│ │ │ └── service/impl/ # Service Implementations
│ │ └── resources/
│ │ ├── application.properties # Application Configuration
│ │ └── log4j2.xml # Logging Configuration
├── pom.xml # Maven POM file
└── README.md # Project Documentation
```

## API Endpoints

1.  Create Item

    Endpoint: POST /api/items

    Description: Create a new inventory item.

    Request Body:

    ```json
    {
      "namaBarang": "Laptop",
      "jumlahStokBarang": 10,
      "nomorSeriBarang": "12345ABC",
      "additionalInfo": "{\"warranty\": \"1 year\"}",
      "gambarBarang": "path/to/image.jpg",
      "createdBy": "admin"
    }
    ```

2.  Get All Items

    Endpoint: GET /api/items
    Description: Retrieve a list of all inventory items.

3.  Get Item by ID

    Endpoint: GET /api/items/{id}
    Description: Retrieve details of a specific inventory item by its ID.

4.  Update Item

    Endpoint: PUT /api/items/{id}
    Description: Update the details of an existing inventory item.
    Request Body: Similar to the create item request body.

5.  Delete Item

    Endpoint: DELETE /api/items/{id}
    Description: Delete an inventory item by its ID.

## Running the Application

1. Start the PostgreSQL Database if it is not running already.
2. Run the Spring Boot Application as mentioned above.

## Logging

The application uses Log4j2 for logging requests and responses to both console and a log file (logs/app.log). You can configure logging settings in the src/main/resources/log4j2.xml file.
