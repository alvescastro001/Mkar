package com.mkt.car.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "CARRO", schema = "MKCAR")
public class Car implements Serializable {

	private static final long serialVersionUID = -6942047825531917367L;

	@Id
	@SequenceGenerator(name = "ID_CAR", sequenceName = "ID_CAR", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_CAR")
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "ANO")
	private int year;
	
	@Column(name = "PLACA")
	private String licensePlate;
	
	@Column(name = "MODELO")
	private String model;
	
	@Column(name = "COR")
	private String cor;
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(Long id, int year, String licensePlate, String model, String cor) {
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

	public void setId(Long id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
