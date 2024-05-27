package com.mkt.car.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
	
	@Bean
	  public OpenAPI myOpenAPI() {
	    Server devServer = new Server();
	    devServer.setDescription("Server URL in Development environment");

	    Server prodServer = new Server();
	    prodServer.setDescription("Server URL in Production environment");

	    Contact contact = new Contact();
	    contact.setName("RD-Saúde");
	    contact.setUrl("https://www.drogaraia.com.br/");

	    License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

	    Info info = new Info()
	        .title("RD-Saúde API1")
	        .version("1.0")
	        .contact(contact)
	        .description("This API exposes endpoints to manage produtos.").termsOfService("https://www.drogasil.com.br/termo-privacidade-app.html")
	        .license(mitLicense);

	    return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
	  }

}
