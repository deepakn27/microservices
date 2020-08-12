package com.springsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.dao.AppRoleDAO;
import com.springsecurity.dao.AppUserDAO;
import com.springsecurity.entity.AppUser;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private AppUserDAO appUserDAO;
	 
	@Autowired
	private AppRoleDAO appRoleDAO;
	
	
	    
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	   
		AppUser appUser = appUserDAO.findByuserName(userName);
		
		if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
		
		List<String> roleNames = appRoleDAO.fetchRoles(appUser.getUserId());
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (!(roleNames.isEmpty())) {
            for (String role : roleNames) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        } 
        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(),appUser.getEncrytedPassword(), grantList);
        return userDetails;
	}

    
}
