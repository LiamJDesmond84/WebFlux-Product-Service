package com.liam.productservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	
	
	@GetMapping("{id}")
	public Mono<ResponseEntity<ProductDto>> getOneProduct(@PathVariable("id") String id) {
		
		return productService.getProductById(id)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	
	
	@PostMapping("")
	public Mono<ProductDto> createProduct(@RequestBody Mono<ProductDto> productDto) {
		
		return productService.insertNewProduct(productDto);
	}
	
	
	
	
	@PutMapping("{id}")
	public Mono<ResponseEntity<ProductDto>> updateProduct(@PathVariable("id") String id, @RequestBody Mono<ProductDto> productDto) {
		
		return productService.updateProduct(id, productDto)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	
	
	@DeleteMapping("{id}")
	public Mono<Void> deleteProduct(@PathVariable("id") String id) {
		
		return productService.deleteProduct(id);
	}
	
	
	
	@GetMapping("range")
	public Mono<Void> findByPriceBetween(@PathVariable("int") Integer int) {
		
		
		
		return productService.deleteProduct(id);
	}
	
}
