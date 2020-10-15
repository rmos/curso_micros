package com.gfi.cursomicros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gfi.cursomicros.dto.EnvironmentsOut;
import com.gfi.cursomicros.service.IEnvironmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "API to search environments",
description = "Descripción pruebas swagger environment", produces = "application/json")
public class EnvironmentController {
	
	private static final String API = "/environment";
    //private static final Logger log = LoggerFactory.getLogger(EnvironmentController.class);
    
    @Autowired
    private IEnvironmentService service;

    @ApiOperation(value = "Get All Environments", produces = "application/json")
	@GetMapping(path = API + "/environments", produces = {
	            MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<EnvironmentsOut> listarEntornos() {

	    	EnvironmentsOut response = service.listarEntornos();
	        
	        HttpStatus statusResponse = HttpStatus.OK;
	        
	        if(response.getEnvironments().isEmpty()){
	        	statusResponse = HttpStatus.NO_CONTENT;
	        }
	        
	        return new ResponseEntity<EnvironmentsOut>(response, statusResponse);
	    }
	 
}
