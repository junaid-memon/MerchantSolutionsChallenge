package de.merchantsolutions.challenge.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import de.merchantsolutions.challenge.dto.UserRegistrationDTO;
import de.merchantsolutions.challenge.model.User;
import de.merchantsolutions.challenge.repository.UserRepository;

@Service
public class LoadDataService {
	private List<UserRegistrationDTO> userRegistrationDTO;
	private UserRepository userRepository;
	
	LoadDataService(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	
	//Hardcoding the users in order to test the functionality
	
	@PostConstruct
	public void init() {
		userRegistrationDTO = new ArrayList<UserRegistrationDTO>();
		UserRegistrationDTO buyer = new UserRegistrationDTO();
		UserRegistrationDTO seller = new UserRegistrationDTO();
		
		buyer.setPassword("$2a$12$qp7bsT3ikMlEQ2nwU6VOkuK3pW3BcjFi302upmu3HOn1ujecfWZ8G");
		buyer.setUserID(1);
		buyer.setUsername("memon");
		buyer.setUserRole("BUYER");
		
		seller.setPassword("$2a$12$qp7bsT3ikMlEQ2nwU6VOkuK3pW3BcjFi302upmu3HOn1ujecfWZ8G");
		seller.setUserID(2);
		seller.setUsername("junaid");
		seller.setUserRole("SELLER");
		
		userRegistrationDTO.add(buyer);
		userRegistrationDTO.add(seller);
		
		System.out.println(userRegistrationDTO);
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
