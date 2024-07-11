package com.assembleyourpc.app.users;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class UsersModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersModuleApplication.class, args);
	}

	@Hidden
	@GetMapping("/")
	public ResponseEntity<String> getAppStatus(){
		return ResponseEntity.ok("UP");
	}
}
