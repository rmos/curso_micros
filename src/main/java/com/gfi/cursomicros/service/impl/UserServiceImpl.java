package com.gfi.cursomicros.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfi.cursomicros.dto.UserOut;
import com.gfi.cursomicros.dto.UsersOut;
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
		
		//Optional<UserEntity> response = userRepository.findById(Long.valueOf(user));
		//UserOut userOut= mapUserToResponseUser(response);
		UserEntity response = userRepository.findByUserId(user);
		UserOut userOut = mapUserToResponseUser(response);
		
		return userOut;
	}

	private UserOut mapUserToResponseUser(UserEntity response) {
		UserOut userOut = new UserOut();
		userOut.setId(response.getId().toString());
		userOut.setName(response.getName());
		userOut.setUserId(response.getUserId());
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

	@Override
	public UsersOut obtenerUsuarioEntorno(String environment) {
		List<UserEntity> response = userRepository.findByEnvironment(environment);
		UsersOut users = new UsersOut();
		users.setUsers(mapResponseEntityToUser(response));
		return users;
	}

	private List<UserOut> mapResponseEntityToUser(List<UserEntity> response) {
		List<UserOut> users = new ArrayList<UserOut>();
		
		for(UserEntity user : response) {
			UserOut userOut = new UserOut();
			userOut.setUserId(user.getUserId());
			userOut.setName(user.getName());
			users.add(userOut);
		}
		return users;
	}


}
