package com.liam.productservice.util;

import org.springframework.beans.BeanUtils;

import com.liam.productservice.dtos.ProductDto;
import com.liam.productservice.entities.Product;

public class EntityDTOUtil {
	
	public static ProductDto toDto(Product product) {
		
		ProductDto productDTO = new ProductDto();
		
//		dto.setDescription(product.getDescription());
//		dto.setPrice(product.getPrice());
		
		// More efficient
		BeanUtils.copyProperties(product, productDTO);
		
		return productDTO;
	}
	
	
	public static Product toEntity(ProductDto productDTO) {
		
		Product product = new Product();
		
		// More efficient
		BeanUtils.copyProperties(productDTO, product);
		
		return product;
	}

}
