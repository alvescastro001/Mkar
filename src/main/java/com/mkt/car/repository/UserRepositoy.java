package com.mkt.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.mkt.car.model.User;

@Repository
public interface UserRepositoy extends JpaRepository<User, Long>{
	
	UserDetails findByLogin(String login);

}
