package com.mkt.car.vo;

import java.io.Serializable;

public class LoginVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6637293531907120809L;

	private Long id;
	private String login;
	private String password;

	public LoginVo(Long id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}
	
	public void validate() throws RuntimeException {
		
		if(this.login.length() == 0) {
			throw new RuntimeException("Login é obrigatório");
		}
		
		if(this.password.length() == 0) {
			throw new RuntimeException("Login é obrigatório");
		}
	}

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

}
