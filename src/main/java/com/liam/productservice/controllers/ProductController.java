package com.liam.productservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.liam.productservice.services.ProductService;

@RestController
public class ProductController {

	
	@Autowired
	private ProductService productService;
}
