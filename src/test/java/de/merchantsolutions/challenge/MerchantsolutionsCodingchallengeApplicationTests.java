package de.merchantsolutions.challenge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.merchantsolutions.challenge.controller.LoginController;

@SpringBootTest
class MerchantsolutionsCodingchallengeApplicationTests {
	
	@Autowired
	 LoginController loginController;

	@Test
	void contextLoads() {
		Assertions.assertThat(loginController).isNot(null);
	}

}
