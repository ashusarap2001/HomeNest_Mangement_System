package com.hostel.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	 private final CustomAuthenticationSuccessHandler successHandler;

	    public SecurityConfiguration(CustomAuthenticationSuccessHandler successHandler) {
	        this.successHandler = successHandler;
	    }
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService getUserDetailsService() {
		return new CustomDetailService();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(getUserDetailsService());
		dao.setPasswordEncoder(bCryptPasswordEncoder());
		return dao;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/admin/**").hasRole("ADMIN")
		.requestMatchers("/candidate/**").hasRole("CANDIDATE")
		.requestMatchers("/**").permitAll()
		.anyRequest().authenticated()
		.and()
		 .formLogin()
         .loginPage("/login") // URL of your custom login page
         .loginProcessingUrl("/loginUser") // URL to process the login form
         .defaultSuccessUrl("/", true) // Redirect on success
         .successHandler(successHandler)
         .failureUrl("/login?error=true") // Redirect on failure
         .usernameParameter("username") // Matches the form input name
         .passwordParameter("password") // Matches the form input name
         .permitAll()
     .and()
     .logout()
         .logoutUrl("/logout")
         .logoutSuccessUrl("/")
         .permitAll();
 return http.build();
	}
}
