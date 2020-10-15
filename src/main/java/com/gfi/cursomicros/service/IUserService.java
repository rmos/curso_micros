package com.gfi.cursomicros.service;

import com.gfi.cursomicros.dto.UserOut;

public interface IUserService {

	UserOut obtenerUsuario(String user);
	void modificarUsuario(String user);
	
}
