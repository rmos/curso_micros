package com.gfi.cursomicros.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfi.cursomicros.dtos.Environment;
import com.gfi.cursomicros.dtos.EnvironmentsOut;
import com.gfi.cursomicros.entities.EnvironmentEntity;
import com.gfi.cursomicros.repositories.EnvironmentRepository;
import com.gfi.cursomicros.services.IEnvironmentService;

@Service
public class EnvironmentServiceImpl implements IEnvironmentService {
	
	@Autowired
	EnvironmentRepository environmentRepository;

	@Override
	public EnvironmentsOut listarEntornos() {
		
		EnvironmentsOut out = new EnvironmentsOut();
		List <Environment> environments = new ArrayList<Environment>();
		List<EnvironmentEntity> envsEntity = (List<EnvironmentEntity>) environmentRepository.findAll();
		environments = mapEnvironmentListToReponse(envsEntity);
		out.setEnvironments(environments);
		return out;
	}

	private List<Environment> mapEnvironmentListToReponse(List<EnvironmentEntity> envsEntity) {
		List <Environment> environments = new ArrayList<Environment>();
		for (EnvironmentEntity env : envsEntity) {
			environments.add(mapEnvironmentToResponse(env));
		}
		return environments;
	}

	private Environment mapEnvironmentToResponse(EnvironmentEntity env) {
		Environment environment = new Environment();
		environment.setEnvironment(env.getEnvironment());
		return environment;
	}


}
