package com.example.Springbootelasticsearch.repository;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.Springbootelasticsearch.entity.Product;

public interface ProductRepo extends ElasticsearchRepository<Product,Integer> {

	Product findProductById(Integer id);

	Product deleteProductById(Integer id);

}
