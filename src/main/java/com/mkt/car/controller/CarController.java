package com.mkt.car.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkt.car.config.ApiConfig;
import com.mkt.car.domain.Car;
import com.mkt.car.dto.CarDTOResponse;
import com.mkt.car.dto.CarDtoRequest;
import com.mkt.car.service.impl.CarServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiConfig.API_VERSION + ApiConfig.API + ApiConfig.API_CAR )
public class CarController {
	
	private final CarServiceImpl service;

    public CarController(CarServiceImpl service) {
        this.service = service;
    }
	
	@GetMapping("/version")
	public String getVersion() {
		return "A versão da API é " + ApiConfig.API_VERSION + ApiConfig.API + ApiConfig.API_CAR ;
		
	}
	
	
	@Operation(summary = "Get all Cars", description = "Get a Cars object by specifying its id. The response is Products object with id, title, description and published status.")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Car.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping
	public List<CarDTOResponse> getCars() {
		return service.cars();
		
	}
	
	
	 @Operation(summary = "Get a car by its id")
		@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Found the car", content = {
						@Content(mediaType = "application/json", schema = @Schema(implementation = Car.class)) }),
				@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
				@ApiResponse(responseCode = "404", description = "Car not found", content = @Content),
				@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/{id}")
	public CarDTOResponse getCarId(@PathVariable Long id) {
		return service.getCar(id);
		
	}
	
	 @Operation(summary = "Insert a car by its id")
	    @ApiResponses(value = { 
	      @ApiResponse(responseCode = "200", description = "Created the car", content = { @Content(mediaType = "application/json",  schema = @Schema(implementation = Car.class)) }),
	      @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content), 
	      @ApiResponse(responseCode = "404", description = "Product not found",  content = @Content),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping
	public void setCar(@RequestBody CarDtoRequest carDto) {
		 service.insert(carDto);
		
	}
	
	 @ApiResponses(value = { 
   	      @ApiResponse(responseCode = "201", description = "Created the car", content = { @Content(mediaType = "application/json",  schema = @Schema(implementation = Car.class)) }),
   	      @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content), 
   	      @ApiResponse(responseCode = "404", description = "Product not found",  content = @Content),
   	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable Long id, @RequestBody CarDtoRequest carDto) {
		 service.update(carDto.getId(), carDto);
		 return ResponseEntity.ok().build();
	}
	 
	
	@DeleteMapping("/{id}")
	public void removeCar(@PathVariable Long id) {
		service.delete(id);
		
	}
	

}
