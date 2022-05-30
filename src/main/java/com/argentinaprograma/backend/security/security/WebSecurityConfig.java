package com.argentinaprograma.backend.security.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final JwtTokenProvider jwtTokenProvider;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    // Disable CSRF (cross site request forgery)
    http.csrf().disable();

    // No session will be created or used by spring security
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    // Entry points
    http.authorizeRequests()//
        .antMatchers("/users/signin").permitAll()//
        .antMatchers("/users/signup").permitAll()//
        .antMatchers("/dato/all/**").permitAll()//
        .antMatchers("/dato/id/**").permitAll()//
        .antMatchers("/dato/add/**").permitAll()//
        .antMatchers("/dato/update/**").permitAll()//
        .antMatchers("/dato/delete/**").permitAll()//    
        .antMatchers("/skill/all/**").permitAll()//
        .antMatchers("/skill/id/**").permitAll()//  
        .antMatchers("/skill/add/**").permitAll()//
        .antMatchers("/skill/update/**").permitAll()//
        .antMatchers("/skill/delete/**").permitAll()//    
        .antMatchers("/proyecto/all/**").permitAll()//
        .antMatchers("/proyecto/id/**").permitAll()//  
        .antMatchers("/proyecto/add/**").permitAll()//
        .antMatchers("/proyecto/update/**").permitAll()//
        .antMatchers("/proyecto/delete/**").permitAll()//        
        .antMatchers("/experiencia/all/**").permitAll()//
        .antMatchers("/experiencia/id/**").permitAll()//
        .antMatchers("/experiencia/add/**").permitAll()//
        .antMatchers("/experiencia/update/**").permitAll()//
        .antMatchers("/experiencia/delete/**").permitAll()//    
        .antMatchers("/educacion/all/**").permitAll()//
        .antMatchers("/educacion/id/**").permitAll()//  
        .antMatchers("/educacion/update/**").permitAll()//  
        .antMatchers("/educacion/add/**").permitAll()//  
        .antMatchers("/educacion/delete/**").permitAll()//  
        .antMatchers("/h2-console/**/**").permitAll()//
        
        
        // Disallow everything else..
        .anyRequest().authenticated();

    // If a user try to access a resource without having enough permissions
    http.exceptionHandling().accessDeniedPage("/login");

    // Apply JWT
    http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));

    // Optional, if you want to test the API from a browser
    // http.httpBasic();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    // Allow swagger to be accessed without authentication
    web.ignoring().antMatchers("/v2/api-docs")//
        .antMatchers("/swagger-resources/**")//
        .antMatchers("/swagger-ui.html")//
        .antMatchers("/configuration/**")//
        .antMatchers("/webjars/**")//
        .antMatchers("/public")
        
        // Un-secure H2 Database (for testing purposes, H2 console shouldn't be unprotected in production)
        .and()
        .ignoring()
        .antMatchers("/h2-console/**/**");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(12);
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

}
