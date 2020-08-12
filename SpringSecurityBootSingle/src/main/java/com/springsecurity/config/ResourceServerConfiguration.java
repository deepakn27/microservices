package com.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    
	private static final String RESOURCE_ID = "resource-server-rest-api";
    
	@Autowired
	DefaultTokenServices tokenservice;
       
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
        resources.tokenServices(tokenservice);
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
    	http.antMatcher("/test/*").authorizeRequests().anyRequest().authenticated();
    	
    	// http.authorizeRequests().antMatchers("/test/*").hasAnyRole("USER","ADMIN");
    	//http.anonymous().disable().authorizeRequests().antMatchers("/test/**").access("hasRole('ROLE_USER')");
    	//http.anonymous().disable().authorizeRequests().antMatchers("/test/**").access("hasRole('ROLE_USER')");
    }
    
}

