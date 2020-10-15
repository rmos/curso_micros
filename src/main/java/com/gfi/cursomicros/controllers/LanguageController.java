package com.gfi.cursomicros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gfi.cursomicros.dto.LanguageIn;
import com.gfi.cursomicros.service.ILanguageService;

import io.swagger.annotations.ApiOperation;

public class LanguageController {
	
	private static final String API = "/language";
    
    @Autowired
    private ILanguageService service;

    @ApiOperation(value = "Create language", produces = "application/json")
	@PostMapping(path = API + "/language", produces = {
	            MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<HttpStatus> obtenerUsuario(
			@RequestBody LanguageIn request) {

	    	service.crearLenguaje(request);
	        
	        HttpStatus statusResponse = HttpStatus.CREATED;
	        
	        return new ResponseEntity<HttpStatus>(statusResponse);
	    }
	 

}
