# Spring POS System API

A Point of Sale (POS) RESTful API developed using Spring. This project includes CRUD operations and transaction management for Customer, Item, Order, and OrderDetail entities, integrated with Hibernate ORM and Spring Data JPA.

## Features

- Manage customers items and orders.
- Real-time inventory management.
- Order creation with payment methods (cash/card/mobile).
- Database: MySQL with Hibernate ORM.
- Exception handling and validation using Spring Validator.
- REST API with JSON responses.

## Tech Stack

- **Java 17**
- **Spring Framework**
- **Hibernate ORM**
- **Spring Data JPA**
- **ModelMapper**
- **Logback**
- **MySQL**

## Project Structure

- **Entities**: Customer, Item, Order
- **DTOs**: CustomerDTO, ItemDTO, OrderDTO
- **Repositories**: CustomerRepository, ItemRepository, OrderRepository
- **Services**: CustomerService, ItemService, OrderService
- **Controllers**: CustomerController, ItemController, OrderController, HealthTestController
- **Utilities**: Mapping, AppUtil
- **Exceptions**: Custom exceptions for handling specific error cases
- **Configuration**: WebAppConfig, WebAppRootConfig

## Validation

Validation is implemented using Hibernate Validator annotations in the DTO classes to ensure data integrity and correctness.

## Logging

Logging is configured using Logback. Logs are written to both the console and a file.

## Custom Exceptions

Custom exceptions are created to handle specific error scenarios, providing meaningful error messages to the client.

## Utilities

- **Mapping**: Utility class for converting between DTOs and entities using ModelMapper.

## Configuration

Configuration files are used to set up the application context, data source, JPA, and transaction management.

## License

This project is licensed under the MIT License - see the [LICENSE](License.txt) file for details.

## Getting Started

### Prerequisites

- Java 17
- MySQL
- Maven

## Installation Steps

<p>1. Clone the Repository</p>

```
git clone https://github.com/VRavindu/POS-System-Backend-Spring
```

<p>2. Build and Run the Application</p>

```
mvn clean install
```

<p>3. The application will start on</p>

```
http://localhost:8080
```


### Usage

- Access the API endpoints using your preferred API client (e.g., Postman).
- Refer to the Postman documentation for detailed API usage.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.


<p align="center">
  &copy; 2024 Vimukthi Ravindu Hewarathna
</p>
