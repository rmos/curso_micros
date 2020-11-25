package com.gfi.cursomicros.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gfi.cursomicros.dtos.EnvironmentsOut;
import com.gfi.cursomicros.services.IEnvironmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value= "API to search environments")
public class EnvironmentController {
	
		private static final String API_ENVIRONMENTS = "/env";
	
		@Autowired
		private IEnvironmentService service;

		@ApiOperation(value="Get all environments", notes= "prueba notas apioperation", produces = "application/json")
		@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
		@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL ERROR SERVER"),
		@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "UNAUTHORIZED"),
		@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "FORBIDDEN"),
		@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "ELEMENTO NOT FOUND") })
		@GetMapping(path = API_ENVIRONMENTS + "/environments", produces = {MediaType.APPLICATION_JSON_VALUE})
		public ResponseEntity<EnvironmentsOut> listarEntornos() {
			
			EnvironmentsOut response = service.listarEntornos();
			
			HttpStatus statusResponse = HttpStatus.OK;
			
			return new ResponseEntity<EnvironmentsOut>(response, statusResponse);
			
		}
		
}
