package com.example.security.service.ecommerce.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.dto.ecommerce.ProductDTO;
import com.example.security.entity.ecommerce.Product;
import com.example.security.entity.ecommerce.ProductType;
import com.example.security.repository.ecommerce.ProductRepository;
import com.example.security.repository.ecommerce.ProductTypeRepository;
import com.example.security.service.ecommerce.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductTypeRepository productTypeRepository;
	
	@Autowired
	ObjectMapper mapper;

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public List<ProductDTO> getAllAvailableProduct() {
		Optional<List<Product>> productAvailable = productRepository.findByAvailable(true);
		if(productAvailable.isPresent()) {

			return productAvailable.get().stream().map(product -> {
				ProductDTO productDTO = mapper.convertValue(product, ProductDTO.class);
				String productType = productTypeRepository.findById(product.getProductTypeId()).orElse(new ProductType()).getTypeName();
				productDTO.setProductType(productType);
				return productDTO;
		}).collect(Collectors.toList());
//			return productAvailable.get();
		}
		
		return null;
	}

	@Override
	public List<ProductDTO> getAllAvailableProduct(String searchText) {
		Optional<List<ProductDTO>> searchList = productRepository.findByProductNameContainingAndAvailable(searchText, true);
		
		if(searchList.isPresent()) {
			return searchList.get();
		}
		
		return null;
	}

}
