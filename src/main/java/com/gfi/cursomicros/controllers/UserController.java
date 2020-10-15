package com.gfi.cursomicros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gfi.cursomicros.dto.UserIn;
import com.gfi.cursomicros.dto.UserOut;
import com.gfi.cursomicros.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "API to search users",
description = "Descripción pruebas swagger environment", produces = "application/json")
public class UserController {
	
	private static final String API = "/user";
    
    @Autowired
    private IUserService service;

    @ApiOperation(value = "Get User", produces = "application/json")
	@PostMapping(path = API + "/user", produces = {
	            MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserOut> obtenerUsuario(
			@RequestBody UserIn request) {

	    	UserOut response = service.obtenerUsuario(request.getUser());
	        
	        HttpStatus statusResponse = HttpStatus.OK;
	        
	        if(response.equals(null)){
	        	statusResponse = HttpStatus.NO_CONTENT;
	        }
	        
	        return new ResponseEntity<UserOut>(response, statusResponse);
	    }
	 
}
