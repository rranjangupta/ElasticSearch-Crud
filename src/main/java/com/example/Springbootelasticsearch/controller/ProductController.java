package com.example.Springbootelasticsearch.controller;

import com.example.Springbootelasticsearch.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Springbootelasticsearch.entity.Product;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/insert")
	public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
		Product insertedProduct = productService.insertProduct ( product );
		return ResponseEntity.status ( HttpStatus.CREATED ).body ( insertedProduct );
	}

	@GetMapping("/findAll")
	public ResponseEntity<Iterable<Product>> getProducts() {
		Iterable<Product> products = productService.getProducts ();
		return ResponseEntity.ok ( products );
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
		try {
			Product product = productService.getProductById(id);
			return ResponseEntity.ok(product);
		} catch (ResourceNotFoundException ex) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(null);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
		try {
			Product updatedProduct = productService.updateProduct(id, product);
			return ResponseEntity.ok(updatedProduct);
		} catch (ResourceNotFoundException ex) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(null);
		}
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable("id") Integer id) {
		try {
			productService.deleteProductById ( id );
			return ResponseEntity.noContent ().build ();
		} catch (ResourceNotFoundException ex) {
			return ResponseEntity
					.status ( HttpStatus.NOT_FOUND )
					.body ( createErrorResponse ( "Product not found with id: " + id ) );
		}
	}

	private ResponseEntity<Product> createErrorResponse(String message) {
		Map<String, Object> errorResponse = new HashMap<> ();
		errorResponse.put ( "timestamp", LocalDateTime.now () );
		errorResponse.put ( "message", message );
		return ResponseEntity.status ( HttpStatus.NOT_FOUND ).body ( null );
	}
}
