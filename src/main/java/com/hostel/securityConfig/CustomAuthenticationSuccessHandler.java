package com.hostel.securityConfig;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		  if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
	            response.sendRedirect("/admin/adminDashboard");
	        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CANDIDATE"))) {
	            response.sendRedirect("/candidate/candidateDashboard");
	        } else {
	            response.sendRedirect("/"); // Default redirect
	        }
		
	}

}
