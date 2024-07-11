package com.assembleyourpc.app;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping
public class ProductModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductModuleApplication.class, args);
	}

	@Hidden
	@GetMapping("/")
	public ResponseEntity<String> getAppStatus(){
		return ResponseEntity.ok("UP");
	}

}
