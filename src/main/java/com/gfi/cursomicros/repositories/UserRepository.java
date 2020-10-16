package com.gfi.cursomicros.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gfi.cursomicros.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	UserEntity findByUserId(String userId);
	
	@Query("SELECT c FROM UserEntity c WHERE c.entorno= :entorno ")
	List<UserEntity> findByEnvironment(@Param("entorno")String entorno);

}
