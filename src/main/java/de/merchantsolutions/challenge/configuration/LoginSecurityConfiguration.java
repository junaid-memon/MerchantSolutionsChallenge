package de.merchantsolutions.challenge.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class LoginSecurityConfiguration{
	
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

	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        
        return new InMemoryUserDetailsManager();
    }

}
