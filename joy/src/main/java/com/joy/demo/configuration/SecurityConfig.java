package com.joy.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.joy.demo.svc.account.accountSvc;

//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity

//public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private accountSvc accountsvc;
	
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
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	public void configuration(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	}
	
	public void configuration(HttpSecurity http) throws Exception{
		http.authorizeRequests()
	        .antMatchers("/member/**").authenticated()
	        .antMatchers("/admin/**").authenticated()
	        .antMatchers("/**").permitAll();
	
		http.formLogin()
	        .loginPage("/login")
	        .defaultSuccessUrl("/")
	        .permitAll();
	
		http.logout()
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        .logoutSuccessUrl("/login")
	        .invalidateHttpSession(true);
	
		http.exceptionHandling()
	        .accessDeniedPage("/denied");
		
	}
	
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountsvc).passwordEncoder(passwordEncoder());
    }
	// jap 사용방식 
//	protected void configuration(HttpSecurity http) throws Exception{
//		http.authorizeHttpRequests()
////				.mvcMatchers("/" , "/info", "/main/**" ).permitAll()
////				.mvcMatchers("/admin").hasRole("ADMIN")
////				// .anyRequest().authenticated()
////				.antMatchers("/board").permitAll()
////				.and()
////			.formLogin()
////				.and()
////			.httpBasic();
//		
//		// authorizeRequests HttpServletRequest 요청 URL 에따라 접근 권한을 설정합니다.
//		//
//		
//		
//		// authenticated 인증된 유저만 접근을 허용합니다.
//		// permitAll모든 유저에게 접근을 허용합니다.
//		// anonymous 인증되지 않은 유만 허용합니다.
//		// denyAll 모든 유저에게 접근을 허용하지 않습니다.
//		
//		
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()
//			.withUser("admin").password("{noop}1234").roles("ADMIN").and()
//			.withUser("user").password("{noop}user1234").roles("USER");
//	}
	
}
