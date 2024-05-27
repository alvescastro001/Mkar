package com.mkt.car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class MktcarApplication {

	private static final Logger logger = LoggerFactory.getLogger(MktcarApplication.class);
	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(MktcarApplication.class, args);
		logger.info("Loja-de-Carros-Iniciado!!!");
	}

}
