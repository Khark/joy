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

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	// authorizeRequests 는 시큐리티 처리에 HttpServletRequest를 이용한다는 것을 의미함 
    	// antMatchers 는 특정한 경로를 지정
    	// permitAll 는 모든 사용자가 접근 가능함을 의미
    	// hasRole 는 시스템상에서 특정 권한을 지닌 사람만 접근이 가능함
    	// 
    	
    	
        http.authorizeRequests()
               // .antMatchers("/member/**").authenticated()
                .antMatchers("/admin/**").authenticated()
                .antMatchers("/joy/**").hasRole("ADMIN")
                .antMatchers("/joy/**").hasRole("MEMBER")
                .antMatchers("/board/**").hasRole("MEMBER")
                .antMatchers("/member/list/**").hasRole("ADMIN")
                .antMatchers("/member/**").authenticated()
                /// .antMatchers("/**").permitAll()
              
               // .antMatchers("/board/**").hasRole("ROLE_MEMBER")
                ;
        	
        		
        
        // form 태그 기반의 로그인을 지원
        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home") // 성공했을 때 가는 주소 
                .permitAll();
        		
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true);
        // 세션timeout 은 application.yml 에 설정한다. 
        
        http.exceptionHandling()
                .accessDeniedPage("/denied");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountsvc).passwordEncoder(passwordEncoder());
    }
    @Configuration
    @EnableGlobalMethodSecurity(securedEnabled =  true, prePostEnabled =  true, jsr250Enabled = true)
    public class MethodSecurity2{
    	
    }

}