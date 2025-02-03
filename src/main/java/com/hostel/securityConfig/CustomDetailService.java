package com.hostel.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hostel.entity.Admin;
import com.hostel.entity.Candidate;
import com.hostel.reposistory.AdminRepo;
import com.hostel.reposistory.cantidateRepo;

@Component

public class CustomDetailService implements UserDetailsService {
	@Autowired
	private AdminRepo ar;

	@Autowired
	private cantidateRepo cr;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = ar.findAdminByEmail(username);
		Candidate candidate = cr.findUserByEmail(username);

		if (admin != null) {
			return new CustomDetail(admin.getEmail(), admin.getPass(), admin.getRole());
		}

		if (candidate != null) {
			return new CustomDetail(candidate.getEmail(), candidate.getPassword(), candidate.getRole());
		}
		throw new UsernameNotFoundException("User not found with email: ");

	}

}
