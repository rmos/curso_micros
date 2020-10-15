package com.gfi.cursomicros.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gfi.cursomicros.entities.EnvironmentEntity;

public interface EnvironmentRepository extends CrudRepository<EnvironmentEntity, Long> {
}
