package com.example.SpringSecurityExample.configure;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import org.aspectj.lang.reflect.CatchClauseSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

import jakarta.annotation.security.PermitAll;
@Configuration
public class ProjectSecurityConfig {
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) ->{ requests
			.requestMatchers("/public/**").permitAll()
			.requestMatchers("/product/allproduct").permitAll()
			.requestMatchers(HttpMethod.OPTIONS).permitAll()
			.requestMatchers("/logoutsuccess").hasAnyAuthority("Admin","User")
			.requestMatchers("/product/**").hasAuthority("Admin");
	
		
		
		////.and().csrf().disable();
		}
		);
		http.csrf((csrf)->csrf.disable());
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		return http.build();
 	}
	
//	@Bean
//	public UserDetailsService userDetailsService(DataSource dataSource) {
//		return new JdbcUserDetailsManager(dataSource);
////		InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
////		manager.createUser(User.withDefaultPasswordEncoder()
////				.username("vasanth").password("123").roles("USER").build());
////		return manager;
//	} 
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		//return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
		
	}
	@Bean
	public AuthenticationManager authenticationManager(
			AuthenticationConfiguration configuration) throws Exception{
		return configuration.getAuthenticationManager();
	}
	
}


