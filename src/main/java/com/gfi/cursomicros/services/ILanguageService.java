package com.gfi.cursomicros.services;

import com.gfi.cursomicros.dtos.LanguageIn;

public interface ILanguageService {

	void crearLenguaje(LanguageIn lenguaje);
	void eliminarLenguaje(String idLang);
}
