package com.mkt.car.domain;

import java.io.Serializable;

public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2239786505651229556L;

	private Long id;
	private int year;
	private String licensePlate;
	private String model;
	private String cor;

	public Car(Long id, int year, String licensePlate, String model, String cor) {
		super();
		this.id = id;
		this.year = year;
		this.licensePlate = licensePlate;
		this.model = model;
		this.cor = cor;
	}

	public void validate() throws RuntimeException {

		if (this.id != null && this.id == 0) {
			throw new RuntimeException("Id de produto é obrigatório");
		}

		if (this.year == 0) {
			throw new RuntimeException("Ano é obrigatório");
		}
		
		if(this.licensePlate.length() == 0) {
			throw new RuntimeException("Placa é obrigatório");
		}
		
		if(this.model.length() == 0) {
			throw new RuntimeException("Modelo é obrigatório");
		}
		
		if(this.cor.length() == 0) {
			throw new RuntimeException("Cor é obrigatório");
		}

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
