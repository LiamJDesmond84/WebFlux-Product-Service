package com.liam.productservice.entities;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Product {
	
	private String Id;
	
	private String description;
	
	private Integer price;

}
