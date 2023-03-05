package com.spring.delivery.config.jwt;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.spring.delivery.entity.User;
import com.spring.delivery.entity.userEnum;

public class JwtProcess {
	
	 public static String create(User user) {
		 String jwtToken = JWT.create()
					.withSubject(user.getUsername())
					.withExpiresAt(new Date(System.currentTimeMillis()+JwtProperties.EXPIRATION_TIME))
					.withClaim("userId",user.getUserId())
					.withClaim("level", user.getLevel().toString())
					.sign(Algorithm.HMAC512(JwtProperties.SECRET));
	        return JwtProperties.TOKEN_PREFIX + jwtToken;
	    }

	    public static User verify(String token) {
	        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(token);
	        String id = decodedJWT.getClaim("userId").asString();
	        String role = decodedJWT.getClaim("level").asString();
	        User user = User.builder().userId(id).level(userEnum.valueOf(role)).build();
	  
	        return user;
	    }
}
