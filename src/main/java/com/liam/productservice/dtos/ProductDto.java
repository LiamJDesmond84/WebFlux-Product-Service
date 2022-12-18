package com.liam.productservice.dtos;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductDto {
	
	private String Id;
	
	private String description;
	
	private Integer price;

}
