package com.gfi.cursomicros.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gfi.cursomicros.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	UserEntity findByUserId(String userId);
	
	UserEntity findUsersByUserId(String userId);
	
	/*@Query()
	List<UserEntity> findByEnvironment(@Param()String entorno);*/

}
