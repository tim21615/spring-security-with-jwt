package com.example.security.service.ecommerce;

import java.util.List;

import com.example.security.dto.ecommerce.ProductDTO;
import com.example.security.entity.ecommerce.Product;

public interface ProductService {
	
	List<Product> getAllProduct();
	List<ProductDTO> getAllAvailableProduct();
	List<ProductDTO> getAllAvailableProduct(String searchText);
	
}
