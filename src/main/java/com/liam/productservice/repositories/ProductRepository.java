package com.liam.productservice.repositories;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.liam.productservice.entities.Product;

import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
	
//	Flux<Product> findByPriceBetween(int min, int max);
	
	Flux<Product> findByPriceBetween(Range<Integer> range);

}
