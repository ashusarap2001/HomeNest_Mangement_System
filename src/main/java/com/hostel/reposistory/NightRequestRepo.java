package com.hostel.reposistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hostel.entity.NightRequest;

import jakarta.transaction.Transactional;

public interface NightRequestRepo extends JpaRepository<NightRequest, Integer>{
	
	  @Query(value = "SELECT * FROM hostel_management.night_out_request WHERE uid = :uid", nativeQuery = true)
	    List<NightRequest> findByUid(@Param("uid") int uid);
	  
	    @Modifying
	    @Transactional
	    @Query(value = "UPDATE hostel_management.night_out_request SET status = 'Accept' WHERE id = :id", nativeQuery = true)
	    void updateStatusToAcceptById(@Param("id") int id);
	    
	    @Modifying
	    @Transactional
	    @Query(value = "UPDATE hostel_management.night_out_request SET status = 'Reject' WHERE id = :id", nativeQuery = true)
	    void updateStatusToRejectById(@Param("id") int id);

}
