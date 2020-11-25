package com.gfi.cursomicros.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfi.cursomicros.dtos.LanguageIn;
import com.gfi.cursomicros.entities.LanguageEntity;
import com.gfi.cursomicros.repositories.LanguageRepository;
import com.gfi.cursomicros.services.ILanguageService;

@Service
public class LanguageServiceImpl implements ILanguageService{
	
	@Autowired
	LanguageRepository languageRepository;

	@Override
	public void crearLenguaje(LanguageIn lenguaje) {

		LanguageEntity entity = mapLanguageToLangEntity(lenguaje);
		languageRepository.save(entity);
		
	}

	private LanguageEntity mapLanguageToLangEntity(LanguageIn lenguaje) {
		LanguageEntity entity = new LanguageEntity();
		entity.setLang(lenguaje.getLang());
		return entity;
	}

	@Override
	public void eliminarLenguaje(String idLang) {
		// TODO Auto-generated method stub
		
	}



}
