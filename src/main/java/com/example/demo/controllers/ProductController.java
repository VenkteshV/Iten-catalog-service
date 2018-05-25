package com.example.demo.controllers;
import com.example.demo.entities.Product;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.services.ProductService;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Slf4j
@RequestMapping("/api/products")
public class ProductController {
private final ProductService productService;
@Autowired
public ProductController(ProductService productService) {
	this.productService=productService;
}

@GetMapping("")
public List<Product> allProducts(HttpServletRequest request) {
	return productService.findAllProducts();
}

@GetMapping("/{code}") 
public Product productByCode(@PathVariable String code) {
	return productService.findProductByCode(code).orElseThrow(() -> new ProductNotFoundException("product with code ["+code+"] doesnt exist"));
}
}
