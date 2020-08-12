package com.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.springsecurity.service.UserDetailServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableAuthorizationServer
public class AuthServerOAuth2Config extends AuthorizationServerConfigurerAdapter {
	
		@Autowired
		DataSource dataSource;
		
		@Autowired
		private AuthenticationManager authenticationManager;

		 @Autowired
		 private UserDetailServiceImpl userDetailsService;
			 
	    @Override
	    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
	        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	    }

	    @Override
	    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
	        clients.jdbc(dataSource).passwordEncoder(passwordEncoder());
	    }
    
	    @Bean
	    public TokenStore tokenStore() {
	        return new JdbcTokenStore(dataSource);
	    }
	    
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Bean
	    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
	        final DataSourceInitializer initializer = new DataSourceInitializer();
	        initializer.setDataSource(dataSource);
	        return initializer;
	    }
	    
	    @Override
	    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	        endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager).userDetailsService(userDetailsService);
	    }

	    
	    
	    @Bean
	    @Primary
	    public DefaultTokenServices tokenServices() {
	        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
	        defaultTokenServices.setTokenStore(tokenStore());
	        defaultTokenServices.setSupportRefreshToken(true);
	        return defaultTokenServices;
	    }
	    
	   
} 

/* @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource defaultDataSource = new DriverManagerDataSource();
			defaultDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			defaultDataSource.setUrl("jdbc:mysql://localhost:3306/WorkDB");
			defaultDataSource.setUsername("root");
			defaultDataSource.setPassword("root");
			return defaultDataSource;
	    }*/