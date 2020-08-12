package com.authorization.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name="App_Role")
public class AppRole {

	@Id
	@GeneratedValue
	@Column(name="Role_Id")
	Long Id;
	
	@Column(name="Role_Name",nullable=false,unique=true)
	String roleName;
	
}
