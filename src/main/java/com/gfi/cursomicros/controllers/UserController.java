package com.gfi.cursomicros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gfi.cursomicros.dtos.UserIn;
import com.gfi.cursomicros.dtos.UserOut;
import com.gfi.cursomicros.services.IUserService;

@RestController
public class UserController {
	
	private static final String API_USERS = "/user";
	
	@Autowired
	private IUserService service;
	
	@PostMapping(path = API_USERS + "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserOut> obtenerUsuario(
			@RequestBody UserIn request) {
		
		validateRequest(request);
		
		UserOut response = service.obtenerUsuario(request.getUser());
		
		HttpStatus statusResponse = HttpStatus.OK;
		
		return new ResponseEntity<UserOut>(response, statusResponse);
		
	}

	private void validateRequest(UserIn request) {
		// TODO Auto-generated method stub
		
	}

}
