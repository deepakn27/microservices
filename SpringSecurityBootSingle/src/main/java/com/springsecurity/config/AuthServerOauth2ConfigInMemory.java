/*package com.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import com.springsecurity.service.UserDetailServiceImpl;

@Configuration
@EnableAuthorizationServer
public class AuthServerOauth2ConfigInMemory extends AuthorizationServerConfigurerAdapter {
	static final int ACCESS_TOKEN_VALIDITY_SECONDS = 120;
    static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 60;
	
	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private AuthenticationManager authenticationManager;

	 @Autowired
	 private UserDetailServiceImpl userDetailsService;
	 
	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

		configurer.inMemory ()
	     .withClient ("client")
	             .authorizedGrantTypes ("password", "refresh_token", "implicit")
	             .scopes ("read", "write")     
	             .secret (passwordEncoder(). encode ("password"))
	             .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS).
					refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS);;   
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore)
				.authenticationManager(authenticationManager).userDetailsService(userDetailsService);
	}
	
	 @Bean
	    public TokenStore tokenStore() {
	        return new InMemoryTokenStore();
	    }
	
	 @Bean
     public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder ();
     }
	 
	 @Override
	  public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
	    oauthServer.allowFormAuthenticationForClients();
	  } 

}*/
