package com.liam.productservice.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.liam.productservice.entities.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}
