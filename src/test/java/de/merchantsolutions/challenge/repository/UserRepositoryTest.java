package de.merchantsolutions.challenge.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import de.merchantsolutions.challenge.model.User;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	@Test
	public void testCreateReadDelete() {
		User user = new User();
		
		user.setUsername("jay");
		user.setPassword("123124123");
		user.setUserRole("BUYER");
		userRepository.save(user);

		Iterable<User> users = userRepository.findAll();
		Assertions.assertThat(users).extracting(User::getUserRole).containsOnly("BUYER");

		userRepository.deleteAll();
		Assertions.assertThat(userRepository.findAll()).isEmpty();
	}
}
