package com.hostel.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.hostel.entity.RoomAllotment;

public interface Room_Allot_Repo extends JpaRepository<RoomAllotment, Long> {

	 @Query("SELECT a FROM RoomAllotment a WHERE a.uniqueid = :uniqueid")
	 RoomAllotment findByUniqueId(@Param("uniqueid") int id);
	 
	 @Query(value = "SELECT COUNT(r) FROM hostel_management.RoomAllot r WHERE r.room_no = :room_no",nativeQuery = true)
	 int countByRoomNo(@Param("room_no") int roomNo);

}
