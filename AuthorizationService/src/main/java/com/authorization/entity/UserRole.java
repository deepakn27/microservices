package com.authorization.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="User_Role")
public class UserRole {

	@Id
	@GeneratedValue
	long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Role_Id",nullable=false,unique=true)
	AppRole appRole;	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="User_Id",nullable=false,unique=true)
	AppUser appUser;
}
