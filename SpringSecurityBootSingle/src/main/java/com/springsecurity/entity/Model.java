package com.springsecurity.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "models")
public class Model {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private Date createdAt;
	
	@Column(nullable = false)
	private String tenant;
	
	public Model(String tenant) {
		this.tenant = tenant;
		this.createdAt=new Date();
	}
	
	public Model()
	{
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}
	
}
