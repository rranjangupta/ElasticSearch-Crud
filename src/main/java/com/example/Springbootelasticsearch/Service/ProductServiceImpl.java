package com.example.Springbootelasticsearch.Service;

import com.example.Springbootelasticsearch.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Springbootelasticsearch.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	public Product insertProduct(Product product) {
		return productRepo.save(product);
	}

	public Iterable<Product> getProducts() {
		return productRepo.findAll();
	}

	public Product getProductById(Integer id) {
		return productRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
	}

	public Product updateProduct(Integer id, Product product) {
		Product existingProduct = productRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

		existingProduct.setPrice(product.getPrice());

		return productRepo.save(existingProduct);
	}


	public void deleteProductById(Integer id) {
		if (!productRepo.existsById(id)) {
			throw new ResourceNotFoundException("Product not found with id: " + id);
		}
		productRepo.deleteById(id);
	}
}
