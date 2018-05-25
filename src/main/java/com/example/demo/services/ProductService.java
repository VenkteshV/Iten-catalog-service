package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
@Slf4j
public class ProductService {
private final ProductRepository productRepository;
@Autowired
public ProductService(ProductRepository productRepository) {
	this.productRepository = productRepository;
}
public List<Product> findAllProducts() {
	List<Product> products = productRepository.findAll();
	return products;
}
public Optional<Product> findProductByCode(String code){
	return productRepository.findByCode(code);
}
}
