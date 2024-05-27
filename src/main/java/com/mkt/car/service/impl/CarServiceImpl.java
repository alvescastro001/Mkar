package com.mkt.car.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.mkt.car.dto.CarDTOResponse;
import com.mkt.car.dto.CarDtoRequest;
import com.mkt.car.dto.UserDTOResponse;
import com.mkt.car.exception.NotFoundException;
import com.mkt.car.mapper.CarMapper;
import com.mkt.car.repository.CarRepository;
import com.mkt.car.service.CarService;

@Component
public class CarServiceImpl implements CarService {

	private static final long serialVersionUID = -7759638189840000704L;
	private final CarRepository repository;
	private final CarMapper mapper;

	public CarServiceImpl(final CarRepository repository, final CarMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	@Override
	public Optional<CarDTOResponse> optionalCar(Long id) {
		return repository.findById(id).map(mapper::toDTO);
	}


	@Override
	public CarDTOResponse getCar(Long id) {
		return optionalCar(id).orElseThrow(() -> new NotFoundException("Carro não encontrado"));
	}

	
	@Override
	public List<CarDTOResponse> cars() {
		return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
	}

	@Override
	public void insert(CarDtoRequest carDto) {
		mapper.toEntityDomain(carDto);
		// insert car
		CarDTOResponse result = mapper.toDTO(repository.save(mapper.toEntity(carDto)));

	}
	
	public void update(Long i, CarDtoRequest dto) {
		CarDTOResponse result = getCar(dto.getId());
		if(result !=null ) {
			repository.save(mapper.toEntity(dto));
			// historicoProdutoRepository.save(mapperHistorico.convertHistorico(dto));
		}
	}
		

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}


	

}
