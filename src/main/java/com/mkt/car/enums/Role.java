package com.mkt.car.enums;

public enum Role {
	
	ADMIN("admmin"),
	USER("user");
	
	private String role;

	Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
	
}
