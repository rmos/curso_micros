package com.gfi.cursomicros.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfi.cursomicros.dto.LanguageIn;
import com.gfi.cursomicros.entities.LanguageEntity;
import com.gfi.cursomicros.repositories.LanguageRepository;
import com.gfi.cursomicros.service.ILanguageService;

@Service
public class LanguageServiceImpl implements ILanguageService {

	@Autowired
	LanguageRepository languageRepository;
	
	@Override
	public void crearLenguaje(LanguageIn lenguaje) {
		
		LanguageEntity entity = mapLanguageToLangEntity(lenguaje);
		languageRepository.save(entity);
		
	}

	private LanguageEntity mapLanguageToLangEntity(LanguageIn lenguaje) {
		LanguageEntity langEntity = new LanguageEntity();
		langEntity.setLang(lenguaje.getLang());
		return langEntity;
	}
	


}
