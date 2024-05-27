package com.mkt.car.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mkt.car.dto.CarDTOResponse;
import com.mkt.car.dto.CarDtoRequest;
import com.mkt.car.model.Car;

@Mapper(componentModel = "spring")
public interface CarMapper{
	
	CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

	CarDTOResponse toDTO(Car car);
		
	Car toEntity(CarDTOResponse carResponseDTO);
		
	Car toEntity(CarDtoRequest carDtoRequest);
	
	com.mkt.car.domain.Car toEntityDomain(CarDtoRequest carDto);

}
