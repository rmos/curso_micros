package com.gfi.cursomicros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gfi.cursomicros.dtos.LanguageIn;
import com.gfi.cursomicros.services.ILanguageService;

@RestController
public class LanguageController {
	
	private static final String API_LANG = "/lang";
	
	@Autowired
	private ILanguageService service;
	
	@PostMapping(path = API_LANG + "/language", produces = {
            MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<HttpStatus> crearLenguaje(
			@RequestBody LanguageIn request) {
		
		validateRequest(request);
		
		service.crearLenguaje(request);
		
		HttpStatus statusResponse = HttpStatus.CREATED;
		
		return new ResponseEntity<HttpStatus>(statusResponse);
		
	}
	
	@DeleteMapping(path = API_LANG + "/language/{idLang}", produces = {
            MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<HttpStatus> eliminarLenguaje(
			@PathVariable("idLang") String idLang) {
		
		//validateRequest(idLang);
		
		service.eliminarLenguaje(idLang);
		
		HttpStatus statusResponse = HttpStatus.OK;
		
		return new ResponseEntity<HttpStatus>(statusResponse);
		
	}

	private void validateRequest(LanguageIn request) {
		// TODO Auto-generated method stub
		
	}

}
