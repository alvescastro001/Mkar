package com.mkt.car.dto;

import java.io.Serializable;

public class CarDtoRequest implements Serializable {

	private static final long serialVersionUID = -5917483878086788027L;

	private Long id;
	private int year;
	private String licensePlate;
	private String model;
	private String cor;

	public CarDtoRequest(Long id, int year, String licensePlate, String model, String cor) {
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
