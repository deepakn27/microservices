package com.springsecurity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springsecurity.entity.UserRole;

public interface AppRoleDAO extends CrudRepository<UserRole, Long> {

	 @Query("SELECT ur.appRole.roleName FROM UserRole ur WHERE ur.appUser.userId=:userId")
	  List<String> fetchRoles(@Param("userId") Long userId);
}
