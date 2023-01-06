package com.liam.productservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liam.productservice.dtos.ProductDto;

import com.liam.productservice.services.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product")
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("all")
	public Flux<ProductDto> getAllProducts() {
		
		return productService.getAllProducts();
	}
	
	
	@GetMapping("id")
	public Mono<ProductDto> getOneProduct(String id) {
		
		return productService.getProductById(id);
	}
	
	@GetMapping("id")
	public Mono<ProductDto> createOneProduct(Mono<ProductDto> productDto) {
		
		return productService.insertNewProduct(productDto);
	}
	
	
	@GetMapping("id")
	public Mono<ProductDto> updateOneProduct(String id, Mono<ProductDto> productDto) {
		
		return productService.updateProduct(id, productDto);
	}
	
	
	@GetMapping("id")
	public Mono<Void> deleteOneProduct(String id) {
		
		return productService.deleteProduct(id);
	}
}
