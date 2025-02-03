package com.hostel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidate_data")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String age;
    private String dob;
    private String address;
    private String contact;
    private String email;
    private String password;
    private String role;
    private int uniqueid;  // Unique ID for references
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getUniqueid() {
		return uniqueid;
	}
	public void setUniqueid(int uniqueid) {
		this.uniqueid = uniqueid;
	}
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", age=" + age + ", dob=" + dob + ", address=" + address
				+ ", contact=" + contact + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", uniqueid=" + uniqueid + "]";
	}
	public Candidate(long id, String name, String age, String dob, String address, String contact, String email,
			String password, String role, int uniqueid) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.address = address;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.role = role;
		this.uniqueid = uniqueid;
	}
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}



  
}
