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
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	
	// GET ALL
	@GetMapping("all")
	public Flux<ProductDto> getAllProducts() {
		
		return productService.getAllProducts();
	}
	
	
	
	// GET ONE
	@GetMapping("{id}")
	public Mono<ResponseEntity<ProductDto>> getOneProduct(@PathVariable("id") String id) {
		
		return productService.getProductById(id)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	
	// CREATE
	@PostMapping("")
	public Mono<ProductDto> createProduct(@RequestBody Mono<ProductDto> productDto) {
		
		return productService.insertNewProduct(productDto);
	}
	
	
	
	// UPDATE
	@PutMapping("{id}")
	public Mono<ResponseEntity<ProductDto>> updateProduct(@PathVariable("id") String id, @RequestBody Mono<ProductDto> productDto) {
		
		return productService.updateProduct(id, productDto)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	
	// DELETE
	@DeleteMapping("{id}")
	public Mono<Void> deleteProduct(@PathVariable("id") String id) {
		
		return productService.deleteProduct(id);
	}
	
	
	
	
	// SEARCH BY RANGE(path variabes)
	@GetMapping("range/{min}/{max}")
	public Flux<ProductDto> findBetweenRange(@PathVariable("min") int min, @PathVariable("max") int max) {
		
		return productService.findBetweenRange(min, max);
	}
	
	
	// SEARCH BY RANGE(query parameters)
	@GetMapping("price-range")
	public Flux<ProductDto> getPriceByRange(@RequestParam("min") int min, @RequestParam("max") int max) {

		return productService.findBetweenRange(min, max);
	}
}
