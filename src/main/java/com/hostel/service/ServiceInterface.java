package com.hostel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hostel.entity.Admin;
import com.hostel.entity.Candidate;
import com.hostel.entity.Contact;
import com.hostel.entity.NightRequest;
import com.hostel.entity.Payment;
import com.hostel.entity.RoomAllotment;
import com.hostel.entity.RoomManagement;
import com.hostel.reposistory.Room_Allot_Repo;

public interface ServiceInterface {
	//Save Admin
	public Admin saveData(Admin admin);
	public List<Admin> getAllData();
	public Admin editById(long id);
	
	
	
	
	//Save Conatct Info
	public Contact saveContactData(Contact contact);
	
	
	//Save Candidate Data
	public Candidate saveCandidateData(Candidate candidate);
	List<Candidate> findAllCandidate();
	public void deleteCandidate(long id);
	public Candidate candidateFindByID(long id);
	
	//Room Candidate 
	
	public RoomManagement saveRoom(RoomManagement management);
	List<RoomManagement> findAllRoom();
	public RoomManagement editRoom(long id);
	public void deleteRoom(long id);
	
	
	//payment
	
	public Payment savePaymentData(Payment payment);
	public List<Payment> getAllPayement();
	public Payment editPaymentById(long id);
	public void deletePaymentByID(long id);

	

	//Room Allotment Data 
	public RoomAllotment saveData(RoomAllotment allot) ;
	
	
	
	///NightRequest
	
	public NightRequest saveRequest(NightRequest request);
	List<NightRequest> getAllRequest();	
	public void deleteNightRequest(int id);
	
	
	
	
	
	
	
	
}
