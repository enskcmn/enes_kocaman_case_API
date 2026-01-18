# API Test Automation Case

The project focuses on testing basic CRUD operations and common API scenarios using the Swagger Petstore API.

## Technologies Used
- Java
- Rest Assured
- TestNG
- Maven

# Project Structure

src/test/java

- api.clients  
  Contains classes responsible for sending API requests.

- api.payload  
  Includes request models and enums used in the API calls.

- api.utilities  
  Utility classes such as route definitions.

- api.tests  
  Test classes grouped as positive and negative scenarios

  Some negative scenarios are limited because the Swagger Petstore API does not validate all invalid inputs.
