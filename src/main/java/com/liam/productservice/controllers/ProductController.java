package com.liam.productservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liam.productservice.dtos.ProductDto;

import com.liam.productservice.services.ProductService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("product")
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("all")
	public Flux<ProductDto> getAllProducts() {
		
		return productService.getAllProducts();
	}
	
}
