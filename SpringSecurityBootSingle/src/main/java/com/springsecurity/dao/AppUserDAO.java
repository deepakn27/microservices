package com.springsecurity.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.entity.AppUser;

@Repository
public interface AppUserDAO extends CrudRepository<AppUser,Long>{

	public AppUser findByuserName(String userName);
}
