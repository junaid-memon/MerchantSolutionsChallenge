package de.merchantsolutions.challenge.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import de.merchantsolutions.challenge.model.Product;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {
	
	@Autowired
	ProductRepository productRepository;

	@Test
	public void testCreateReadDelete() {
		Product product = new Product();
		
		product.setName("Berry");
		product.setPrice(4.5);
		productRepository.save(product);

		Iterable<Product> products = productRepository.findAll();
		Assertions.assertThat(products).extracting(Product::getName).containsOnly("Berry");

		productRepository.deleteAll();
		Assertions.assertThat(productRepository.findAll()).isEmpty();
	}

}
