package com.mkt.car.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.mkt.car.enums.Role;
import com.mkt.car.vo.LoginVo;

public class UserDtoRequest implements Serializable {

	private static final long serialVersionUID = 999100227736002491L;

	private Long id;
	private String fistName;
	private String lastName;
	private String email;
	private LocalDateTime birthday;
	private String phone;
	private LoginVo login;
	private Role role;

	public UserDtoRequest() {
		super();
	}
	


	public UserDtoRequest(Long id, String fistName, String lastName, String email, LocalDateTime birthday, String phone,
			LoginVo login, Role role) {
		super();
		this.id = id;
		this.fistName = fistName;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.phone = phone;
		this.login = login;
		this.role = role;
	}



	public Long getId() {
		return id;
	}



	public String getFistName() {
		return fistName;
	}



	public String getLastName() {
		return lastName;
	}



	public String getEmail() {
		return email;
	}



	public LocalDateTime getBirthday() {
		return birthday;
	}



	public String getPhone() {
		return phone;
	}



	public LoginVo getLogin() {
		return login;
	}



	public Role getRole() {
		return role;
	}



	
}
