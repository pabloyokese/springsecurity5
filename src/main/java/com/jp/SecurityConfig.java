package com.jp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
public class SecurityConfig {
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		http
			.authorizeExchange()
//				.pathMatchers("/users").access(this::isRob)
				.pathMatchers("/login", "/signup", "/webjars/**").permitAll()
				.anyExchange().authenticated()
				.and()
			.httpBasic().and()
			.formLogin()
				.loginPage("/login");
		return http.build();
	}

	
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
	
	
	@Bean
	MapReactiveUserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("juan").password("123").roles("ADMIN").build();
		return new MapReactiveUserDetailsService(user);
	}

}
