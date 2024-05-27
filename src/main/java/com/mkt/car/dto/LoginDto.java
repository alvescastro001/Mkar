package com.mkt.car.dto;

import java.io.Serializable;

public class LoginDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7273990068873818254L;

	private String login;
	private String password;

	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginDto(String login, String password) {
		super();
		this.login = login;
		this.password = password;
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
