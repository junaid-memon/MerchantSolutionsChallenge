package de.merchantsolutions.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.merchantsolutions.challenge.dto.UserRegistrationDTO;
import de.merchantsolutions.challenge.model.User;
import de.merchantsolutions.challenge.repository.UserRepository;

@Service
public class UserService {

	private static UserRepository userRepository;
	
	@Autowired
	private static UserRegistrationDTO userRegistrationDTO;
	
	public UserService(UserRepository userRepository){
		UserService.userRepository = userRepository;
		//UserService.userRegistrationDTO = userRegistrationDTO;
	}
	
	
	public void saveUser() {
		User user = new User();
		user.setUsername(userRegistrationDTO.getUsername());
		user.setPassword(userRegistrationDTO.getPassword());
		user.setUserRole(userRegistrationDTO.getUserRole());	
		userRepository.save(user);
	}
}
