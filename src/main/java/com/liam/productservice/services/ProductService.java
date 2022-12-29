package com.liam.productservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liam.productservice.dtos.ProductDto;
import com.liam.productservice.repositories.ProductRepository;
import com.liam.productservice.util.EntityDTOUtil;

import reactor.core.publisher.Flux;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Flux<ProductDto> getAllProducts() {
		
		return productRepository.findAll()
//				.map(x -> EntityDTOUtil.toDto(x));
				.map(EntityDTOUtil::toDto);
	}

}
