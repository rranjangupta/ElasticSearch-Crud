# Spring Boot Elasticsearch Demo

This is a simple Spring Boot application demonstrating CRUD operations with Elasticsearch.

## Setup

1. **Clone the repository:**

   ```bash
   git clone <repository-url>
   ```

2. **Install dependencies:**

   Ensure you have Maven & Elasticsearch installed. Navigate to the project directory and run:

   ```bash
   mvn clean install -DskipTests
   ```

3. **Run the application:**

   You can run the application using Maven:

   ```bash
   mvn spring-boot:run
   ```

   Alternatively, you can run the JAR file generated in the `target` directory:

   ```bash
   java -jar target/<jar-file-name>.jar
   ```

## Usage

The application exposes RESTful endpoints for performing CRUD operations on products.

- `POST /api/products/insert`: Insert a new product.
- `GET /api/products/findAll`: Retrieve all products.
- `GET /api/products/findById/{id}`: Retrieve a product by ID.
- `PUT /api/products/update/{id}`: Update a product by ID.
- `DELETE /api/products/deleteById/{id}`: Delete a product by ID.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or create a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
