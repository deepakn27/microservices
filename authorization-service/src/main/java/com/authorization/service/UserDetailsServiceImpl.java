package com.authorization.service;

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

import com.authorization.entity.AppUser;
import com.authorization.repository.AppRoleRepository;
import com.authorization.repository.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	AppUserRepository appUserRepository;
	
	@Autowired
	AppRoleRepository appRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AppUser appuser = appUserRepository.findByUserName(username);
		
		List<String> roleNames = appRoleRepository.fetchRoles(appuser.getUserId());
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (!(roleNames.isEmpty())) {
            for (String role : roleNames) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        } 
		
		return new User(appuser.getUserName(),appuser.getEncrytedPassword(),grantList);
	}

}
