package com.gfi.cursomicros.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfi.cursomicros.dto.Environment;
import com.gfi.cursomicros.dto.EnvironmentsOut;
import com.gfi.cursomicros.entities.EnvironmentEntity;
import com.gfi.cursomicros.repositories.EnvironmentRepository;
import com.gfi.cursomicros.service.IEnvironmentService;

@Service
public class EnvironmentServiceImpl implements IEnvironmentService {
	
	@Autowired
	EnvironmentRepository environmentRepository;

	@Override
	@Transactional
	public EnvironmentsOut listarEntornos() {
		List<Environment> environments = new ArrayList<Environment>();
		EnvironmentsOut envs = new EnvironmentsOut();
		List<EnvironmentEntity> envsEntity = (List<EnvironmentEntity>) environmentRepository.findAll();
		environments = mapEnvironmentListToResponseList(envsEntity);
		envs.setEnvironments(environments);
		return envs;
	}

	private List<Environment> mapEnvironmentListToResponseList(List<EnvironmentEntity> envs) {
		List<Environment> environments = new ArrayList<Environment>();
		for (EnvironmentEntity env : envs) {
			environments.add(mapEnvironmentToResponseEnv(env));
		}
		return environments;
	}

	private Environment mapEnvironmentToResponseEnv(EnvironmentEntity env) {
		Environment environment = new Environment();
		environment.setEnvironment(env.getEnvironment());
		environment.setId(env.getId());
		return environment;
	}

}
