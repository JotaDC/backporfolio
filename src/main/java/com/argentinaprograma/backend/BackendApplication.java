package com.argentinaprograma.backend;

import com.argentinaprograma.backend.security.model.AppUser;
import com.argentinaprograma.backend.security.model.AppUserRole;
import com.argentinaprograma.backend.security.service.UserService;
import java.util.ArrayList;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.CrossOrigin;
import static org.springframework.web.cors.CorsConfiguration.ALL;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.util.pattern.PathPatternParser;

//@CrossOrigin(origins = {"http://localhost:9000", "null"})
@SpringBootApplication
@RequiredArgsConstructor
//implements CommandLineRunner
public class BackendApplication {
final UserService userService;
	public static void main(String[] args) {
            
            	SpringApplication.run(BackendApplication.class, args);
	}
       
      
//        @Bean
//	public CorsFilter corsFilter() {
//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//		corsConfiguration.setAllowCredentials(true);
//		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
//				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
//				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
//		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
//				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
//		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//		return new CorsFilter(urlBasedCorsConfigurationSource);
//	}


  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
//para crear las cuentas de users and password
//  @Override
//  public void run(String... params) throws Exception {
//    AppUser admin = new AppUser();
//    admin.setUsername("admin");
//    admin.setPassword("admin");
//    admin.setEmail("admin@email.com");
//    admin.setAppUserRoles(new ArrayList<>(Arrays.asList(AppUserRole.ROLE_ADMIN)));
//
//    userService.signup(admin);
//
//    AppUser client = new AppUser();
//    client.setUsername("client");
//    client.setPassword("client");
//    client.setEmail("client@email.com");
//    client.setAppUserRoles(new ArrayList<>(Arrays.asList(AppUserRole.ROLE_CLIENT)));
//
//    userService.signup(client);
//  }

    
        
 
}


