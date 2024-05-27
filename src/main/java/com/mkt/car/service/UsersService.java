package com.mkt.car.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mkt.car.dto.UserDTOResponse;
import com.mkt.car.dto.UserDtoRequest;

@Service
public interface UsersService extends Serializable{
	
	List<UserDTOResponse> users();
	Optional<UserDTOResponse> optionalUser(final Long id);
	UserDTOResponse getUser(final Long id);
	void insert(UserDtoRequest carDto);
	void update (Long i, UserDtoRequest dto);
	void delete (Long id);

}
