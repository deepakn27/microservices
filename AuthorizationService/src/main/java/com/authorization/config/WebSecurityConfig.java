package com.authorization.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.authorization.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Autowired
	 private UserDetailsServiceImpl userDetailsService;
	 
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable();
		http.sessionManagement()	
		.maximumSessions(1)
		.expiredUrl("/login?maxsession=true");
		
		http.authorizeRequests().antMatchers("/","/login","/logout","oauth/token").permitAll();
		http.authorizeRequests().antMatchers("/dashboard").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		
		http.authorizeRequests().and().formLogin().loginProcessingUrl("/userlogin") 
        .loginPage("/login")
        .defaultSuccessUrl("/dashboard")
        .failureUrl("/login?error=true")
        .usernameParameter("username")
        .passwordParameter("password")
        .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout=true");
		
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
