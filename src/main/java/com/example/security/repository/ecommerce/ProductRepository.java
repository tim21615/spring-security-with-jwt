package com.example.security.repository.ecommerce;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.security.dto.ecommerce.ProductDTO;
import com.example.security.entity.ecommerce.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	Optional<List<Product>> findByAvailable(boolean available);
	
	@Query(value = "select new com.example.security.dto.ecommerce.ProductDTO(p.productId, p.productName, t.typeName as productType, p.productPrice, p.stock, p.available, p.productPicture) from Product p inner join ProductType t on p.productTypeId = t.typeId where p.productName like %?1% and p.available = ?2")
	Optional<List<ProductDTO>> findByProductNameContainingAndAvailable(String searchText, boolean available);
}
