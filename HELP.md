# Bank Web App

A web application designed for banking operations, built with Spring Boot and PostgreSQL.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java JDK 8 or higher
- Maven
- PostgreSQL

### Setup

1. **Clone the Repository**:
- git clone https://github.com/yaashall01/bank-web-app.git
- cd bank-web-app


2. **Set up PostgreSQL**:

- Ensure PostgreSQL is running on your machine.
- Create a database for the project:

  ```
  createdb bank_app_db
  ```

- Update `src/main/resources/application.properties` (or `application.yml`) with your PostgreSQL username, password, and other necessary configurations.

3. **Build and Run**:

Using Maven:

- mvn clean install
- mvn spring-boot:run


This will start the application on the default port `8080`. Open your browser and navigate to `http://localhost:8080`.

### Features

- [ ] User Registration & Login
- [ ] Account Management
- [ ] Transaction History
- [ ] Funds Transfer
- [ ] Rebot Support

## Technologies Used

- **Spring Boot** - The web framework used
- **PostgreSQL** - Database
- **Maven** - Dependency Management
- **Postman** - API Development Environment
- **JWT** - Authentication
- **JUnit** - Testing
- **Javamail** - Email Service 

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
