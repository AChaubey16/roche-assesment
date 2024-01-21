# Fizz Buzz REST Server

This project implements a robust and production-ready Fizz-Buzz REST Server using Java with Spring Boot. The server exposes a REST API endpoint for Fizz-Buzz logic and includes a statistical endpoint.

## Requirements
- Java 8 or higher
- Maven (for building)

## Building and Running the Server

To build the project, navigate to the project root and run:

```bash
mvn clean install
To run the server, execute the generated JAR file:

bash
Copy code
java -jar target/fizzbuzz-rest-server.jar
The server will be accessible at http://localhost:8080.

REST API Endpoints
Fizz-Buzz Endpoint
bash
Copy code
GET /api/fizzbuzz?int1={int1}&int2={int2}&limit={limit}&str1={str1}&str2={str2}
Parameters:
int1: integer (e.g., 3)
int2: integer (e.g., 5)
limit: integer (e.g., 20)
str1: string (e.g., "Fizz")
str2: string (e.g., "Buzz")
Statistics Endpoint
bash
Copy code
GET /api/statistics
Returns the parameters corresponding to the most used request and the number of hits for that request.
Unit Tests
The project includes comprehensive unit tests for the FizzBuzzService and StatisticsService. To run the tests, execute:

bash
Copy code
mvn test
Additional Notes
The project uses Spring Boot for simplicity and ease of development.
The StatisticsService is designed to keep track of the most used Fizz-Buzz parameters.
Third-Party Libraries
Spring Boot: Used for building and running the application.
JUnit 5: Used for writing unit tests.
