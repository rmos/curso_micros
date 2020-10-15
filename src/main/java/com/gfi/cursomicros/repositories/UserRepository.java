package com.gfi.cursomicros.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gfi.cursomicros.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
