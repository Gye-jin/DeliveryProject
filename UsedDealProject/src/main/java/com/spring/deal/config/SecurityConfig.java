package com.spring.deal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.spring.deal.config.jwt.JwtAuthenticationFilter;
import com.spring.deal.config.jwt.JwtAuthorizationFilter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
		
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public class CustomSecurityFilterManager extends AbstractHttpConfigurer<CustomSecurityFilterManager, HttpSecurity> {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
            http.addFilter(new JwtAuthenticationFilter(authenticationManager));
            http.addFilter(new JwtAuthorizationFilter(authenticationManager));

        }
    }
		
		
	
		@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	        .authorizeRequests()
	        .antMatchers("/join","/login").permitAll()
			.antMatchers("/posts/**","/users/**").authenticated()
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.formLogin().disable()
			.httpBasic().disable();
	        http.apply(new CustomSecurityFilterManager());

	        return http.build();
	    }
	
	
}
