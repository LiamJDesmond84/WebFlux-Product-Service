package com.liam.productservice.entities;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@ToString
public class Product {
	
	@Id
	private String Id;
	
	private String description;
	
	private Integer price;

}
