package com.gfi.cursomicros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gfi.cursomicros.dtos.EnvironmentsOut;
import com.gfi.cursomicros.services.IEnvironmentService;

@RestController
public class EnvironmentController {
	
		private static final String API_ENVIRONMENTS = "/env";
	
		@Autowired
		private IEnvironmentService service;

		@GetMapping(path = API_ENVIRONMENTS + "/environments", produces = {MediaType.APPLICATION_JSON_VALUE})
		public ResponseEntity<EnvironmentsOut> listarEntornos() {
			
			EnvironmentsOut response = service.listarEntornos();
			
			HttpStatus statusResponse = HttpStatus.OK;
			
			return new ResponseEntity<EnvironmentsOut>(response, statusResponse);
			
		}
		
}
