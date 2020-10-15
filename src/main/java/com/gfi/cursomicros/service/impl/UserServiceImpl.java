package com.gfi.cursomicros.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfi.cursomicros.dto.UserOut;
import com.gfi.cursomicros.entities.UserEntity;
import com.gfi.cursomicros.repositories.UserRepository;
import com.gfi.cursomicros.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserRepository userRepository;


	@Override
	@Transactional
	public UserOut obtenerUsuario(String user) {
		
		Optional<UserEntity> response = userRepository.findById(Long.valueOf(user));
		UserOut userOut= mapUserToResponseUser(response);
		
		return userOut;
	}

	private UserOut mapUserToResponseUser(Optional<UserEntity> response) {
		UserOut userOut = new UserOut();
		UserEntity userEntity = response.get();
		userOut.setId(userEntity.getId().toString());
		userOut.setName(userEntity.getName());
		return userOut;
	}

	@Override
	public void modificarUsuario(String user) {
		// TODO Auto-generated method stub
		
	}


}
