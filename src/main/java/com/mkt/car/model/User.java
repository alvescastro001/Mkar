package com.mkt.car.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mkt.car.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIO", schema = "MKCAR")
public class User implements Serializable, UserDetails {

	private static final long serialVersionUID = 3360708105280189945L;

	@Id
	@SequenceGenerator(name = "ID_USER", sequenceName = "ID_USER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_USER")
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "FISTNAME")
	private String fistName;
	
	@Column(name = "LASTNAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@Column(name = "DT_ANIV")
	private LocalDateTime birthday;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE")
	private Role role;
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public User(Long id, String fistName, String lastName, String email, LocalDateTime birthday, String phone,
			String login, String password, Role role) {
		super();
		this.id = id;
		this.fistName = fistName;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.phone = phone;
		this.login = login;
		this.password = password;
		this.role = role;
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
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		if(this.role == Role.ADMIN) {
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		}else {
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
		}
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
