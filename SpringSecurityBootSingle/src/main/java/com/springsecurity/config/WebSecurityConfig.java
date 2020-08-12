package com.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.springsecurity.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Autowired
	 private UserDetailServiceImpl userDetailsService;
	 
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable();
		http.cors().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.authorizeRequests().antMatchers("/oauth/token").permitAll()
		.anyRequest().authenticated();
				
		//http.authorizeRequests().and().rememberMe().tokenRepository(this.persistentTokenRepository()).tokenValiditySeconds(60);;
		}
	
	 @Override
	 public void configure(AuthenticationManagerBuilder auth) throws Exception {
	     auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	     }
	 
	 @Bean
	 public PersistentTokenRepository persistentTokenRepository() {
	     InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
	     return memory;
	 }
	 
	 @Override
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
	
	 }
