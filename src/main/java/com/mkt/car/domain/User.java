package com.mkt.car.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.mkt.car.enums.Role;
import com.mkt.car.vo.LoginVo;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8709872493123724147L;

	private Long id;
	private String fistName;
	private String lastName;
	private String email;
	private LocalDateTime birthday;
	private String phone;
	private LoginVo login;
	private Role role;
	private List<Car> cars;

	public User(Long id, String fistName, String lastName, String email, LocalDateTime birthday, String phone,
			LoginVo login, Role role, List<Car> cars) {
		super();
		this.id = id;
		this.fistName = fistName;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.phone = phone;
		this.login = login;
		this.role = role;
		this.cars = cars;
	}

	public void validate() throws RuntimeException {

		if (this.id != null && this.id == 0) {
			throw new RuntimeException("Id de produto é obrigatório");
		}

		if (this.fistName.length() == 0) {
			throw new RuntimeException("FirtName é obrigatório");
		}

		if (this.lastName.length() == 0) {
			throw new RuntimeException("LastName é obrigatório");
		}

		if (this.email.length() == 0) {
			throw new RuntimeException("Email é obrigatório");
		}

		if (this.birthday != null) {
			throw new RuntimeException("Data de aniversário é obrigatório");
		}
		
		if (this.role != null) {
			throw new RuntimeException("Role de aniversário é obrigatório");
		}

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

	public LoginVo getLogin() {
		return login;
	}

	public void setLogin(LoginVo login) {
		this.login = login;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
