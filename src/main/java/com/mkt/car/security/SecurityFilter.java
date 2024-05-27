package com.mkt.car.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mkt.car.repository.UserRepositoy;
import com.mkt.car.service.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	
	
	private final TokenService service;
	private final UserRepositoy userRepository;

    public SecurityFilter(TokenService service, UserRepositoy userRepository) {
        this.service = service;
        this.userRepository = userRepository;
    }
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		var token = this.recoverToken(request);
		String valor = "";
		if(token != null && "Bearer".equalsIgnoreCase(valor)) {
			valor = token.toString();
		}else if(token != null && !"Bearer".equalsIgnoreCase(token) && !token.equalsIgnoreCase("[object Object]")){
			token = this.recoverToken(request);
		}else {
			token = null;
		}
		if(token != null && !"Bearer".equalsIgnoreCase(valor)) {
			var login = service.validationToken(token);
			UserDetails user = userRepository.findByLogin(login);
			
			var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		filterChain.doFilter(request, response);
		
	}

	private String recoverToken(HttpServletRequest request) {
		var authHeader = request.getHeader("Authorization");
		if (authHeader == null) return null;
		return authHeader.replace("Bearer ", "");
	}

}
