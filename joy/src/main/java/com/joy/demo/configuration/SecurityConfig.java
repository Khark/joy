package com.joy.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity

//public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// 기존방식 
//	@Override
//	protected void configure(HttpSecurity http) throws Exception{
//		
//		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
//	}
//	
//	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication().withUser("woo").password("{noop}woobro").roles("USER");
//		
//	}
//	
	// jap 사용방식 
	protected void configuration(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
				.mvcMatchers("/" , "/info", "/main/**" ).permitAll()
				.mvcMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.and()
			.httpBasic();
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()
//			.withUser("admin").password("{noop}1234").roles("ADMIN").and()
//			.withUser("user").password("{noop}user1234").roles("USER");
//	}
	
}
