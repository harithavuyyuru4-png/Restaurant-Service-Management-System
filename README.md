# Restaurant Service Management System

## Project Overview
The Restaurant Service Management System is a RESTful web application developed using Java and Spring Boot. It helps manage restaurant information and menu details through REST APIs.

The application provides CRUD (Create, Read, Update, and Delete) operations for restaurants and their menus. Swagger UI is used to explore and test the API endpoints.

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- REST APIs
- Swagger / OpenAPI
- Maven

## Features
- Add new restaurant details
- Retrieve all restaurants and restaurant details by ID
- Update restaurant information
- Delete restaurant records
- Add menu items with item name, price, and category
- Retrieve, update, and delete menu items
- Manage the relationship between restaurants and menu items
- Test REST API endpoints using Swagger UI

## Project Structure
- `model` – Entity classes for Restaurant and Menu
- `repository` – Spring Data JPA repositories
- `controller` – REST API controllers
- `application.properties` – Application and database configuration

## Database Configuration
This project uses MySQL as its database.

Configure your database name, username, and password in `application.properties` before running the application.

**Note:** Do not upload real database passwords or other credentials to GitHub.

## How to Run the Project
1. Clone or download this repository.
2. Open the project in Eclipse or another Java IDE.
3. Configure the MySQL database connection.
4. Run the Spring Boot application.
5. Open Swagger UI in your browser to explore and test the APIs.

Swagger UI URL (if configured with Springdoc OpenAPI):

`http://localhost:8080/swagger-ui/index.html`

Replace `8080` with the port configured in your application.

## API Operations
The application supports CRUD operations for restaurant and menu resources through REST endpoints.

Use Swagger UI to view the exact endpoint paths, HTTP methods, request bodies, and responses.

## Learning Outcomes
- Building RESTful APIs using Spring Boot
- Performing database operations using Spring Data JPA
- Mapping entity relationships using JPA
- Connecting a Spring Boot application to MySQL
- Testing and documenting APIs using Swagger
