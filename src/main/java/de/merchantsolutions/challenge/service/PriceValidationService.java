package de.merchantsolutions.challenge.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.merchantsolutions.challenge.model.Product;
import de.merchantsolutions.challenge.repository.ProductRepository;

@Service
public class PriceValidationService {

	private ProductRepository productRepository;
	private static String status;

	PriceValidationService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public ResponseEntity<String> validatePrice(Double givenPrice, String productName) {
		Iterable<Product> iterable = productRepository.findAll();
		status = "";
		iterable.forEach(data -> {
			if (data.getName().equals(productName) && data.getPrice() > givenPrice) {
				
				status = "failed";
				
			} else if (data.getName().equals(productName) && data.getPrice() <= givenPrice) {
				
				status = "accepted";
				
			}
		});
		return ResponseEntity.ok(status);
	}

}
