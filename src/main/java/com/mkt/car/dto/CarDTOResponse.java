package com.mkt.car.dto;

import java.io.Serializable;

public class CarDTOResponse implements Serializable {

	private static final long serialVersionUID = 67679223169054730L;

	private Long id;
	private int year;
	private String licensePlate;
	private String model;
	private String cor;

	

	public CarDTOResponse(Long id, int year, String licensePlate, String model, String cor) {
		super();
		this.id = id;
		this.year = year;
		this.licensePlate = licensePlate;
		this.model = model;
		this.cor = cor;
	}

	public Long getId() {
		return id;
	}

	public int getYear() {
		return year;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public String getModel() {
		return model;
	}

	public String getCor() {
		return cor;
	}

	
}
