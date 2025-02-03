package com.hostel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "room_allot")
public class RoomAllotment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int uniqueid;
    private String name;
    private int room_no;
    private String room_type;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getUniqueid() {
		return uniqueid;
	}
	public void setUniqueid(int uniqueid) {
		this.uniqueid = uniqueid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	@Override
	public String toString() {
		return "RoomAllotment [id=" + id + ", uniqueid=" + uniqueid + ", name=" + name + ", room_no=" + room_no
				+ ", room_type=" + room_type + "]";
	}
	public RoomAllotment(long id, int uniqueid, String name, int room_no, String room_type) {
		super();
		this.id = id;
		this.uniqueid = uniqueid;
		this.name = name;
		this.room_no = room_no;
		this.room_type = room_type;
	}
	public RoomAllotment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
