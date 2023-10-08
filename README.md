# OpenLabHub
Submission for the NASA Space Apps Challenge 2023

# Challenge
[A Marketplace for Open Science Projects](https://www.spaceappschallenge.org/2023/challenges/a-marketplace-for-open-science-projects/)

## Project Description

This project encompasses the development of an API that is not currently integrated with the mobile application. Due to time constraints, the integration of both projects was not completed. However, the API is fully functional and operational, serving as a standalone component.

The API is designed to interact with a relational database through Hibernate using the Java Persistence API (JPA). It effectively manages all necessary tables and their respective properties, ensuring data integrity and persistence.

## API Functionality

The API provides the following endpoints for managing projects and users:

### Projects
- **GET /project/projects**: Retrieve a list of all projects.
- **GET /project/{id}**: Retrieve a specific project by its unique identifier.
- **POST /project/create/{userId}**: Create a new project, including its associated tags.

### Users
- **GET /user/users**: Retrieve a list of all users.
- **GET /user/{id}**: Retrieve a specific user by their unique identifier.
- **POST /user/create**: Create a new user.

Please note that the API is not exhaustive and does not include all possible endpoints. Only the endpoints listed above are implemented due to time constraints.

## How to Test the API

To test the functionality of the API, you can follow these steps:

1. Clone the repository to your local environment.

2. Navigate to the API directory.

3. Execute the API using your preferred Java development environment or build tool.

4. Use the provided Postman collection included in the repository to test the API endpoints. Import the collection into Postman and configure the necessary environment variables (e.g., base URL).

5. Run the Postman requests to interact with the API and verify its functionality.

## Conclusion

Although the API and mobile application are not currently integrated, the API is fully functional and capable of managing projects and users. It provides endpoints for querying and creating data, ensuring the integrity of the underlying database. Please be aware that only a limited set of endpoints are implemented due to time constraints.

Feel free to explore and test the API using the provided Postman collection.

For any questions or concerns, please contact the project maintainers.

Thank you for your interest in our project!

# Developed by ["Cat.tar.gz"](https://www.spaceappschallenge.org/2023/find-a-team/cattargz/)
- Bonafede, Marco
- Casale, Matías
- Schenoni, Emmanuel
