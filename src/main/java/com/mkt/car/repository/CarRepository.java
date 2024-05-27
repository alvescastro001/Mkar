package com.mkt.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkt.car.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
