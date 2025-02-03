package com.hostel.reposistory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.hostel.entity.Candidate;

public interface cantidateRepo extends JpaRepository<Candidate, Long> {
	public Candidate findUserByEmail(String email);

	@Query(value = "SELECT count(id) FROM hostel_management.candidate_data", nativeQuery = true)
	long countIdNative();

	
	 @Query("SELECT a FROM Candidate a WHERE a.email = :email")
	 Candidate findByEmail(@Param("email") String email);

	}

