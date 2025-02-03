package com.hostel.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hostel.entity.RoomManagement;

public interface roomRepo extends JpaRepository<RoomManagement, Long>{

	@Query(value = "SELECT count(u.id) from hostel_management.room_management u", nativeQuery = true)
	long countIdRoomNative();
	
	
	@Query(value = "SELECT count(room_status) FROM hostel_management.room_management where room_status='available'", nativeQuery = true)
	long countAvailableRoom();
	
	
	@Query(value = "SELECT count(room_status) FROM hostel_management.room_management where room_status='occupied'", nativeQuery = true)
	long countOccupiedRoom();
	


}
