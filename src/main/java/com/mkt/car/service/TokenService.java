package com.mkt.car.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.mkt.car.model.User;

@Service
public class TokenService {

	@Value("$(api.security.token.secret)")
	private String secret;
	
	public String genereteToken(User user) {
		
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create()
					.withIssuer("mktcar")
					.withSubject(user.getLogin())
					.withExpiresAt(generationExpitationDate())
					.sign(algorithm);
			return token;
		} catch (JWTCreationException e) {
			throw new RuntimeException("Erro ao gerar o token ", e);
		}
		
	}
	
	public String validationToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm)
					.withIssuer("mktcar")
					.build()
					.verify(token)
					.getSubject();
		} catch (JWTVerificationException e) {
			return "";
		}
	}
	
	private Instant generationExpitationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
		
	}
}
