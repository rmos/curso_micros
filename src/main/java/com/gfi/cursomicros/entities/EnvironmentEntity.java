package com.gfi.cursomicros.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "environments")
public class EnvironmentEntity {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    
    @Column(name="environment")
    private String environment;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}


}

