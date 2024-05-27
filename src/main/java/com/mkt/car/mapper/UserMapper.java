package com.mkt.car.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.mkt.car.dto.UserDTOResponse;
import com.mkt.car.dto.UserDtoRequest;
import com.mkt.car.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper{
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserDTOResponse toDTO(User user);
		
	User toEntity(UserDTOResponse userDTOResponse);
	
	@Mapping(target="login", source = "userDtoRequest.login.login")
	@Mapping(target="password", source = "userDtoRequest.login.password")
	User toEntity(UserDtoRequest userDtoRequest);
	
	com.mkt.car.domain.User toEntityDomain(UserDtoRequest userDto);

}
