package de.merchantsolutions.challenge.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import de.merchantsolutions.challenge.dto.ProductRegistrationDTO;
import de.merchantsolutions.challenge.model.Product;
import de.merchantsolutions.challenge.repository.ProductRepository;

@Service
public class ProductLoadDataService {

	private String[][] productArray = { { "Bannana", "2.5" }, { "Apple", "5.0" }, { "Olive Oil", "4.99" },
			{ "Bread", " 0.99" } };

	private List<ProductRegistrationDTO> productRegistrationDTO;
	private ProductRepository productRepository;

	ProductLoadDataService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@PostConstruct
	public void init() {
		
		productRegistrationDTO = new ArrayList<ProductRegistrationDTO>();
		for (String[] product : productArray) {
			
			ProductRegistrationDTO data = new ProductRegistrationDTO();
			data.setName(product[0]);
			data.setPrice(Double.parseDouble(product[1]));
			productRegistrationDTO.add(data);	
		}
		MaptoEntity();
	}

	private void MaptoEntity() {
		for (ProductRegistrationDTO dto : productRegistrationDTO) {
			Product product = new Product();
			product.setName(dto.getName());
			product.setPrice(dto.getPrice());

			productRepository.save(product);

		}
	}
}
