package com.cts.lms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.lms.dto.RegisterDto;

import com.cts.lms.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1.0/lms")
public class UserController {

	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/company/register")
	public ResponseEntity<RegisterDto> registerUser(@Valid @RequestBody RegisterDto registerDto) {
		
		return new ResponseEntity<>(userService.registerUser(registerDto), HttpStatus.CREATED);
		
	}
}
