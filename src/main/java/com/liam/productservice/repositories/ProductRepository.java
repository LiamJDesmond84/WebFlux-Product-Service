package com.liam.productservice.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.liam.productservice.entities.Product;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}
