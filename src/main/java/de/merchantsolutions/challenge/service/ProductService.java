package de.merchantsolutions.challenge.service;

import org.springframework.stereotype.Service;

import de.merchantsolutions.challenge.model.Product;
import de.merchantsolutions.challenge.repository.ProductRepository;

@Service
public class ProductService {
	
	
	private ProductRepository productRepository;
	
	ProductService(ProductRepository productRepository){
		this.productRepository = productRepository;
	}
	
	public Product update(Product product) {
		return  productRepository.save(product);
		
	}

}
