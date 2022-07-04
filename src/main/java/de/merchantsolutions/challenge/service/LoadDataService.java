package de.merchantsolutions.challenge.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import de.merchantsolutions.challenge.dto.UserRegistrationDTO;
import de.merchantsolutions.challenge.model.User;
import de.merchantsolutions.challenge.repository.UserRepository;

public class LoadDataService {
	private List<UserRegistrationDTO> userRegistrationDTO;
	private UserRepository userRepository;
	
	LoadDataService(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@PostConstruct
	public void init() {
		userRegistrationDTO = new ArrayList<UserRegistrationDTO>();
		UserRegistrationDTO data = new UserRegistrationDTO();
		
		data.setPassword("sdagadregsdgsg1");
		data.setUserID(1);
		data.setUsername("memon");
		data.setUserRole("BUYER");
		
		userRegistrationDTO.add(data);
		
		MaptoEntity();
		
	}

	private void MaptoEntity() {
		
		for (UserRegistrationDTO dto : userRegistrationDTO) {
		User user = new User();
		user.setPassword(dto.getPassword());
		user.setUserID(dto.getUserID());
		user.setUsername(dto.getUsername());
		user.setUserRole(dto.getUserRole());
		
		userRepository.save(user);
		}
	}
}
