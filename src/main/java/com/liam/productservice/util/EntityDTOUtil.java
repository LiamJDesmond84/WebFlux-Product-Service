package com.liam.productservice.util;

import com.liam.productservice.dtos.ProductDto;
import com.liam.productservice.entities.Product;

public class EntityDTOUtil {
	
	public static ProductDto toDto(Product product) {
		
		ProductDto dto = new ProductDto();
		
		dto.setDescription(product.getDescription());
		dto.setPrice(product.getPrice());
		
		return dto;
	}

}
