package com.liam.productservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import com.liam.productservice.dtos.ProductDto;
import com.liam.productservice.repositories.ProductRepository;
import com.liam.productservice.util.EntityDTOUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Flux<ProductDto> getAllProducts() {
		
		return productRepository.findAll()
//				.map(x -> EntityDTOUtil.toDto(x));
				.map(EntityDTOUtil::toDto);
	}
	
	public Mono<ProductDto> getProductById(String id) {
		return productRepository.findById(id)
				.map(EntityDTOUtil::toDto);
	}
	
	public Mono<ProductDto> insertNewProduct(Mono<ProductDto> productDto) {
		 return productDto
//				 .map(x -> EntityDTOUtil.toEntity(x));
				 .map(EntityDTOUtil::toEntity)
				 .flatMap(productRepository::insert)
				 .map(EntityDTOUtil::toDto);
	}
	
	public Mono<ProductDto> updateProduct(String id, Mono<ProductDto> productDto) {
		 return productRepository.findById(id)
				 .flatMap(p -> productDto
						 .map(EntityDTOUtil::toEntity)
						 .doOnNext(e -> e.setId(id))
				 .flatMap(productRepository::save))
				.map(EntityDTOUtil::toDto);
	}
	
	
	// - Has to be subscribed(otherwise the pipeline will not do anything), hence Mono<Void>, or else will show errors
	public Mono<Void> deleteProduct(String id) {
		return productRepository.deleteById(id);
	}
	
	
	public Flux<ProductDto> findBetweenRange(int min, int max) {
		return productRepository.findBetweenRange(Range.closed(min, max))
				.map(EntityDTOUtil::toDto);
	}

}
