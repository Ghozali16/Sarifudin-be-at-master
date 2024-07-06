# Sistem Informasi Sekolah

## Specification
- Java version 17.0.10
- Spring Boot version 2.7.18
- MySQL version 8.0.37

## Installation
- Clone the repository:
  ```bash
  git clone https://github.com/anggiirawan13/sistem-informasi-sekolah.git
  ```

## Setup
- Create a database named `05tple003_anggiirawan` in your MySQL server.
- Open the `be` folder in your text editor or IDE.
- Rename the `application.properties.sample` file to `application.properties`.
- Update the values of `spring.datasource.username` and `spring.datasource.password` in the `application.properties` file according to your MySQL database username and password.

## Build Setup

```bash
# Build the project
$ mvn clean install

# Run the application
$ java -jar target/cashier-app.jar
```

### Notes:
- Make sure you have Java version 17.0.10, Spring Boot version 2.7.18, and MySQL version 8.0.37 installed on your system.
- Adjust the database configuration in the `application.properties` file based on your MySQL setup.
- Use `mvn clean install` to build the project and `java -jar target/cashier-app.jar` to run the application.