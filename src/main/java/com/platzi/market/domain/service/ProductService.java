package com.platzi.market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAll(){
		return productRepository.getAll();
	}
	
	public Optional<Product> getProduct(Integer productId){
		return productRepository.getProduct(productId);
	}
	
	public Optional<List<Product>> getByCategory(Integer categoryId){
		return productRepository.getByCategory(categoryId);
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public boolean delete(Integer productId) {
		//Opcion1
		return getProduct(productId).map(product -> {
			productRepository.delete(productId);
			return true;
		}).orElse(false);
		
		//Opcion2
		/*if(getProduct(productId).isPresent()) {
			productRepository.delete(productId);
			return true;
		} else {
			return false;
		}*/
	}
}
