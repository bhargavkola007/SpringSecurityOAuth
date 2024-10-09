package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.dto.SignUpDTO;
import com.main.service.AuthService;

@RestController
@RequestMapping("/signup")
public class SignUpController {

	private final AuthService auth;
	
	@Autowired
	public SignUpController(AuthService auth) {
		this.auth=auth;
	}
	@PostMapping("/new")
	public ResponseEntity<String> signupProcess(@RequestBody SignUpDTO signup){
		boolean isUserCreated=auth.createUser(signup);
		if(isUserCreated) {
			return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully...");
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Creation Failed...");
		}
	}
}
