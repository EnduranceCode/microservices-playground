package demo.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



/****************** README *******************

IN ORDER TO ENABLE AUTHENTICATION AND AUTHORIZATION, 
UNCOMMENT BELLOW COMMENTS NOTE1 AND NOTE2

************* END README ********************/


/* 
prePostEnabled: enables support for @PreAuthorize and @PostAuthorize annotations
securedEnabled enables support for @Secured annotation. 
sr250Enabled enables support for the @RolesAllowed annotation
*/
/** 
//NOTE1: ENABLE AUTHORIZATION SECURITY
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true, jsr250Enabled = true)
**/

@Configuration
@EnableWebSecurity
/*  WebSecurityConfigurerAdapter ESTÁ DEPRECTED POR VERSÕES ACIMA da Spring boot version 2.1.6.RELEASE */
public class BasicSecurityConfig  extends WebSecurityConfigurerAdapter {


	/* FONTES: https://www.marcobehler.com/guides/spring-security
	           https://www.javadevjournal.com/spring-boot/spring-boot-security-auto-configuration/
	*/

	@Override
	public void configure(HttpSecurity http) throws Exception {
				
		// desabilita segurança por permissão		
		http		   
    	.authorizeRequests()
		.antMatchers(
				"/**")				
		.permitAll();
		
		
		/**
		// NOTE2: ENABLE AUTENTICATION SECURITY
		
		http	
  		     // disable Cross Site Request Forgery,  
  		     // <input name="_csrf" type="hidden" value="078648ad-1527-4a7e-8055-1ffa5c4e26b2" /> 
  		     // (util only for websites)  		      
		    .csrf().disable()
		    
        	.authorizeRequests()			
        	.antMatchers("/swagger/**").permitAll()				
				 .antMatchers("/api/store/**").hasAnyRole("SALESMAN","CUSTOMER") // hasAnyAuthority("ROLE_SALESMAN")
				 //.antMatchers("/api/store/**").permitAll() // even ROLE_RH would be permission
				 .antMatchers("/api/humman-resources/**").hasAnyAuthority("ROLE_RH") // when using AnyAuthority is need to put prefix ROLE_ 
				  //.permitAll()
			.anyRequest().denyAll()		        	
			.anyRequest().authenticated()				 
        	.and()
        		.formLogin() // enable page login default from Spring
        			//.permitAll()
        			.successForwardUrl("/page-sucess")        			
        		.and()
        			.httpBasic()
        		.and()
        			.logout()
        			.permitAll();
        				
		 **/    
		 		  
	}
	
	
	 @Override
     public void configure(WebSecurity web) throws Exception {
		
		// desabilita segurança por IGNORING		
		//web
		//.ignoring().antMatchers("/**");
					
         web
			//.ignoring().antMatchers("/api/orders","/v2/api-docs",
         	.ignoring().antMatchers("/v2/api-docs",
			 "/configuration/ui",
			 "/swagger-resources/**",
			 "/configuration/security",
			 "/swagger-ui.html",
			 "/webjars/**");

     }
   
	
    @Bean
    @Override
    /*  UserDetailsService is ignored if we declare: configure(AuthenticationManagerBuilder auth) */
    public UserDetailsService userDetailsService() {

    	
        UserDetails user1 =
                User.withUsername("john")
                        .password(getPasswordEncoder().encode("0000"))
                        .roles("SALESMAN")                        
                        .build();
        
        UserDetails user2 =
                User.withUsername("mary")
                        .password(getPasswordEncoder().encode("1111"))
                        .roles("CUSTOMER")                        
                        .build();
       
    	
        UserDetails user3 =
                User.withUsername("paul")
                        .password(getPasswordEncoder().encode("2222"))
                        .roles("RH")                        
                        .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }

    public PasswordEncoder getPasswordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() 
			throws Exception {
		return super.authenticationManagerBean();
	}
	
	
 
/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) 
			throws Exception {
		
		// <<<<<<<<<<<< AUTENTICACAO >>>>>>>>>>
		
		// SE USUARIO NÃO FOR ENCONTRADO RETORNARÁ:   400 Bad Request  (Bad credentials) /		
		
		// enconde em base64 não é obrigatório, mas desejado, obs: o front tb precisa encodar ao chamar a api /oauth/token
		String cUser1 = "teste";  // sem Base64 para testar com formLogin() 
		String cPass1 = "1234";  // sem Base64 para testar com formLogin()
		String cUser2 = "teste2";  // sem Base64 para testar com formLogin() 
		String cPass2 = "1234";  // sem Base64 para testar com formLogin()
		
		String cUser2 = Base64.getEncoder().encodeToString("teste2".getBytes()); 
		String cPass2 = Base64.getEncoder().encodeToString("1234".getBytes());
		
		String cUser3 = Base64.getEncoder().encodeToString("teste3".getBytes()); 
		String cPass3 = Base64.getEncoder().encodeToString("1234".getBytes());
		

		//PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
				
		String c = getPasswordEncoder().encode(cPass1);
		
		
		auth.inMemoryAuthentication()
		.withUser(cUser1)		
		.password(c)
		.roles("SALER")
		.and()
		.withUser(cUser2)
		.password(getPasswordEncoder().encode(cPass2))		
		.roles("MANAGER")
		.and()
		.withUser(cUser3)
		.password(getPasswordEncoder().encode(cPass3))		
		.roles("MANAGER");	
	}
*/



	


	


}
