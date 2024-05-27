package com.mkt.car.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mkt.car.mapper.UserMapper;
import com.mkt.car.repository.UserRepositoy;

@Service
public class AutorizationService implements UserDetailsService {
	
	private final UserRepositoy repository;
	private final UserMapper mapper;

	public AutorizationService(final UserRepositoy repository, final UserMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return repository.findByLogin(username);
	}

}
