package de.merchantsolutions.challenge.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import de.merchantsolutions.challenge.repository.UserRepository;
import de.merchantsolutions.challenge.service.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class LoginSecurityConfiguration{
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/registerProduct", "/purchase", "/productList")
            .hasAuthority("SELLER")
            .antMatchers("/productList", "/purchase")
            .hasAuthority("BUYER")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/purchase", true)
            .failureUrl("/login?error")
            .permitAll()
            .and()
            .logout()
            .permitAll();
        
        return http.build();
    }
	
	@Bean
    public InMemoryUserDetailsManager configureAuthentication() {
		System.out.println("Calling authenticator");
		
	//	UserDetails user = userDetailsService.loadUserByUsername();
		return new InMemoryUserDetailsManager(user);
    }
	

}
