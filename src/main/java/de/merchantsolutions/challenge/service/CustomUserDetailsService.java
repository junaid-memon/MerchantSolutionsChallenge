package de.merchantsolutions.challenge.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import de.merchantsolutions.challenge.model.User;
import de.merchantsolutions.challenge.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService{

	private UserRepository userRepository;
	
	CustomUserDetailsService (UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User Not found!!");
		}
		
	    return new CustomUserDetails(user);
	}
}
