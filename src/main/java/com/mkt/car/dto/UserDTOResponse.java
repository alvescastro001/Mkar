package com.mkt.car.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDTOResponse implements Serializable {

	private static final long serialVersionUID = 59523898070349736L;

	private Long id;
	private String fistName;
	private String lastName;
	private String email;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDateTime birthday;
	private String phone;
	private String login;
	private String password;

	public UserDTOResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public UserDTOResponse(Long id, String fistName, String lastName, String email, LocalDateTime birthday,
			String phone, String login, String password) {
		super();
		this.id = id;
		this.fistName = fistName;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.phone = phone;
		this.login = login;
		this.password = password;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
