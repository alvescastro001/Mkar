package com.mkt.car.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mkt.car.dto.LoginDto;
import com.mkt.car.dto.LoginResponseDto;
import com.mkt.car.model.User;
import com.mkt.car.service.TokenService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("auth")
public class LoginController {
	
	private final AuthenticationManager authenticationManager ;
	private final TokenService tokenService ;

    public LoginController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }
	
	@PostMapping("/login")
	public ResponseEntity login (@RequestBody @Valid LoginDto login) {
		var userNamePassword = new UsernamePasswordAuthenticationToken(login.getLogin(), login.getPassword());
		var auth = authenticationManager.authenticate(userNamePassword);
		
		var token = tokenService.genereteToken((User) auth.getPrincipal());
		return ResponseEntity.ok(new LoginResponseDto(token));
	}
	

}
