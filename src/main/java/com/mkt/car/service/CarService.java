package com.mkt.car.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mkt.car.dto.CarDTOResponse;
import com.mkt.car.dto.CarDtoRequest;

@Service
public interface CarService extends Serializable{
	
	List<CarDTOResponse> cars();
	Optional<CarDTOResponse> optionalCar(final Long id);
	CarDTOResponse getCar(final Long id);
	void insert(CarDtoRequest carDto);
	void update (Long i, CarDtoRequest dto);
	void delete (Long id);

}
