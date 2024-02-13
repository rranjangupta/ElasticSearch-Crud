package com.example.Springbootelasticsearch.Service;


import com.example.Springbootelasticsearch.entity.Product;

public interface ProductService {

	Product insertProduct(Product product);

	Iterable<Product> getProducts();

	Product getProductById(Integer id);

	Product updateProduct(Integer id, Product product);

	void deleteProductById(Integer id);
}
