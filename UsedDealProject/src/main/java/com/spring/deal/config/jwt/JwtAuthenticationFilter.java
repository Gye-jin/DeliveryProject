package com.spring.deal.config.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.deal.entity.User;

//스프링 시큐리티에서 UsernamePasswordAuthenticationFilter가 있음.
//login 요청해서 username, password 전송하면(post)
//usernamepasswordAuthenticationFilter 동작을 함.
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private final AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        setFilterProcessesUrl("/login");
        this.authenticationManager = authenticationManager;
    }
	
	// /login 요청을 하면 로그인 시도를 위해서 실행되는 함수
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {

			ObjectMapper om = new ObjectMapper();
			User user;
			user = om.readValue(request.getInputStream(), User.class);
			System.out.println("login2");
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					user.getUserId(), user.getPassword());
			System.out.println(user.getUserId());
			System.out.println(user.getPassword());
			System.out.println(authenticationToken);
			Authentication authentication = authenticationManager.authenticate(authenticationToken);
			System.out.println("authentication");
			return authentication;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

		return null;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		System.out.println("successfulAuthentication");
		User user = (User) authResult.getPrincipal();
		String jwtToken = JwtProcess.create(user);
		response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX+jwtToken);
	}



}
