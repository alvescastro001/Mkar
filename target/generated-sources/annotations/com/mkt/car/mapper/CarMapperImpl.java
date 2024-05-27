package com.mkt.car.mapper;

import com.mkt.car.dto.CarDTOResponse;
import com.mkt.car.dto.CarDtoRequest;
import com.mkt.car.model.Car;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-16T09:55:56-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210419-1022, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public CarDTOResponse toDTO(Car car) {
        if ( car == null ) {
            return null;
        }

        Long id = null;
        int year = 0;
        String licensePlate = null;
        String model = null;
        String cor = null;

        id = car.getId();
        year = car.getYear();
        licensePlate = car.getLicensePlate();
        model = car.getModel();
        cor = car.getCor();

        CarDTOResponse carDTOResponse = new CarDTOResponse( id, year, licensePlate, model, cor );

        return carDTOResponse;
    }

    @Override
    public Car toEntity(CarDTOResponse carResponseDTO) {
        if ( carResponseDTO == null ) {
            return null;
        }

        Car car = new Car();

        car.setId( carResponseDTO.getId() );
        car.setYear( carResponseDTO.getYear() );
        car.setLicensePlate( carResponseDTO.getLicensePlate() );
        car.setModel( carResponseDTO.getModel() );
        car.setCor( carResponseDTO.getCor() );

        return car;
    }

    @Override
    public Car toEntity(CarDtoRequest carDtoRequest) {
        if ( carDtoRequest == null ) {
            return null;
        }

        Car car = new Car();

        car.setId( carDtoRequest.getId() );
        car.setYear( carDtoRequest.getYear() );
        car.setLicensePlate( carDtoRequest.getLicensePlate() );
        car.setModel( carDtoRequest.getModel() );
        car.setCor( carDtoRequest.getCor() );

        return car;
    }

    @Override
    public com.mkt.car.domain.Car toEntityDomain(CarDtoRequest carDto) {
        if ( carDto == null ) {
            return null;
        }

        Long id = null;
        int year = 0;
        String licensePlate = null;
        String model = null;
        String cor = null;

        id = carDto.getId();
        year = carDto.getYear();
        licensePlate = carDto.getLicensePlate();
        model = carDto.getModel();
        cor = carDto.getCor();

        com.mkt.car.domain.Car car = new com.mkt.car.domain.Car( id, year, licensePlate, model, cor );

        return car;
    }
}
