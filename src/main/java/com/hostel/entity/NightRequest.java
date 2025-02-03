package com.hostel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NightOutRequest")
public class NightRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int uID;
	private String name;
	private String Reason;
	private String date;
	private String Time;
	private String status;
	private int room_no;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	@Override
	public String toString() {
		return "NightRequest [id=" + id + ", uID=" + uID + ", name=" + name + ", Reason=" + Reason + ", date=" + date
				+ ", Time=" + Time + ", status=" + status + ", room_no=" + room_no + "]";
	}
	public NightRequest(long id, int uID, String name, String reason, String date, String time, String status,
			int room_no) {
		super();
		this.id = id;
		this.uID = uID;
		this.name = name;
		Reason = reason;
		this.date = date;
		Time = time;
		this.status = status;
		this.room_no = room_no;
	}
	public NightRequest() {
		super();
		// TODO Auto-generated constructor stub
	}



}
