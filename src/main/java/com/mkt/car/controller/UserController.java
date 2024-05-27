package com.mkt.car.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkt.car.config.ApiConfig;
import com.mkt.car.dto.UserDTOResponse;
import com.mkt.car.dto.UserDtoRequest;
import com.mkt.car.service.impl.UserServiceImpl;
import com.mkt.car.vo.LoginVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiConfig.API_VERSION + ApiConfig.API + ApiConfig.API_USER )
public class UserController {
	
	private final UserServiceImpl service;
	private final AuthenticationManager authenticationManager ;

    public UserController(UserServiceImpl service, AuthenticationManager authenticationManager) {
        this.service = service;
        this.authenticationManager = authenticationManager;
    }
	
	@GetMapping("/version")
	public String getVersion() {
		return "A versão da API é " + ApiConfig.API_VERSION + ApiConfig.API + ApiConfig.API_USER ;
		
	}
	
	@GetMapping
	public List<UserDTOResponse> getUsers() {
		return service.users();
		
	}
	
	@GetMapping("/{id}")
	public UserDTOResponse  getUserId(@PathVariable Long id) {
		 return service.getUser(id);
	}
	
	@PostMapping
	public ResponseEntity setUser(@RequestBody @Valid UserDtoRequest userDto) {
		if(!service.userLogin(userDto.getLogin().getLogin())) {
			return ResponseEntity.badRequest().build();
		}
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(userDto.getLogin().getPassword());
		
		LoginVo loginVo = new LoginVo(null, userDto.getLogin().getLogin(), encryptedPassword);
		UserDtoRequest userDtoRequest = new UserDtoRequest(null, userDto.getFistName(), userDto.getLastName(), userDto.getEmail(), userDto.getBirthday(), userDto.getPhone(), loginVo, userDto.getRole());
		service.insert(userDtoRequest);
		return ResponseEntity.ok().build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity editUser(@PathVariable Long id, @RequestBody UserDtoRequest userDto) {
		 service.update(userDto.getId(), userDto);
		return ResponseEntity.ok().build();
		
	}
	
	@DeleteMapping("/{id}")
	public void removeUser(@PathVariable Long id) {
		 service.delete(id);
	}

}
