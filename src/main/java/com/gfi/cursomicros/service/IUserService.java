package com.gfi.cursomicros.service;

import com.gfi.cursomicros.dto.UserOut;
import com.gfi.cursomicros.dto.UsersOut;

public interface IUserService {

	UserOut obtenerUsuario(String user);
	void modificarUsuario(String user);
	UsersOut obtenerUsuarioEntorno(String environment);
	
}
