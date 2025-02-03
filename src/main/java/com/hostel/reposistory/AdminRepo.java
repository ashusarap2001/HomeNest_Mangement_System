package com.hostel.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hostel.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long> {
	public Admin findAdminByEmail(String email);
	
	 @Query("SELECT a FROM Admin a WHERE a.email = :email")
	    Admin findByEmail(@Param("email") String email);
	
	

	}
