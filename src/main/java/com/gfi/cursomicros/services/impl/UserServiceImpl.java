package com.gfi.cursomicros.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfi.cursomicros.dtos.UserOut;
import com.gfi.cursomicros.entities.UserEntity;
import com.gfi.cursomicros.repositories.UserRepository;
import com.gfi.cursomicros.services.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserOut obtenerUsuario(String user) {

		UserEntity response = userRepository.findUsersByUserId(user);
		UserOut userOut = mapUserToResponseUser(response);
		return userOut;
	}

	private UserOut mapUserToResponseUser(UserEntity response) {
		UserOut userOut = new UserOut();
		userOut.setId(response.getId().toString());
		userOut.setName(response.getName());
		userOut.setUserId(response.getUserId());
		userOut.setEntorno(response.getEntorno());
		return userOut;
	}

}
