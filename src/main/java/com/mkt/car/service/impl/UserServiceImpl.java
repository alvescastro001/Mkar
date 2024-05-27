package com.mkt.car.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.mkt.car.dto.UserDTOResponse;
import com.mkt.car.dto.UserDtoRequest;
import com.mkt.car.exception.NotFoundException;
import com.mkt.car.mapper.UserMapper;
import com.mkt.car.repository.UserRepositoy;
import com.mkt.car.service.UsersService;

@Component
public class UserServiceImpl implements UsersService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4004259025559914982L;
	
	private final UserRepositoy repository;
	private final UserMapper mapper;

	public UserServiceImpl(final UserRepositoy repository, final UserMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<UserDTOResponse> users() {
		return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
	}

	@Override
	public Optional<UserDTOResponse> optionalUser(Long id) {
		return repository.findById(id).map(mapper::toDTO);
	}

	@Override
	public UserDTOResponse getUser(Long id) {
		return optionalUser(id).orElseThrow(() -> new NotFoundException("usuário não encontrado"));
	}

	@Override
	public void insert(UserDtoRequest userDto) {
		mapper.toEntityDomain(userDto);
		// insert car
		UserDTOResponse result = mapper.toDTO(repository.save(mapper.toEntity(userDto)));
		
	}

	@Override
	public void update(Long i, UserDtoRequest dto) {
		UserDTOResponse result = getUser(dto.getId());
		if(result !=null ) {
			UserDTOResponse valor = mapper.toDTO(repository.save(mapper.toEntity(dto)));
			// historicoProdutoRepository.save(mapperHistorico.convertHistorico(dto));
		}
		
	}

	@Override
	public void delete(Long id) {
		UserDTOResponse result = getUser(id);
		if(result !=null ) {
			
			mapper.toEntity(result);
			repository.deleteById(result.getId());
		}
	}
	
	public boolean userLogin(String login) {
		boolean isOK = false;
		if(repository.findByLogin(login) != null) {
			isOK = false;
		}else {
			isOK = true;
		}
		return isOK;
	}

	
	

}
