package com.hostel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="roomManagement ")
public class RoomManagement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int roomNumber;
	private String roomType;
	private String roomStatus;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	@Override
	public String toString() {
		return "RoomManagement [id=" + id + ", roomNumber=" + roomNumber + ", roomType=" + roomType + ", roomStatus="
				+ roomStatus + "]";
	}
	public RoomManagement(long id, int roomNumber, String roomType, String roomStatus) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.roomStatus = roomStatus;
	}
	public RoomManagement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
