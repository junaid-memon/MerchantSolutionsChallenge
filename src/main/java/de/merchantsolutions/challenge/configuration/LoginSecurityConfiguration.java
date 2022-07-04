package de.merchantsolutions.challenge.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import de.merchantsolutions.challenge.dto.UserRegistrationDTO;
import de.merchantsolutions.challenge.service.CustomUserDetails;


@Configuration
@EnableWebSecurity
public class LoginSecurityConfiguration{
	
	@Autowired
	//private UserDetailsService userDetailsService;
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/registerProduct")
            .hasAuthority("SELLER")
            .antMatchers("/productList")
            .hasAuthority("BUYER")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login").permitAll();
        
        return http.build();
    }

	
//	@Bean
//	AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		return provider;
//		
//	}
	
	@Bean
    public InMemoryUserDetailsManager configureAuthentication() {
		//userDetails.add(new User());
		return new InMemoryUserDetailsManager();
    }

}
