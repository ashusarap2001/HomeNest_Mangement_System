package com.hostel.service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hostel.entity.Admin;
import com.hostel.entity.Candidate;
import com.hostel.entity.Contact;
import com.hostel.entity.NightRequest;
import com.hostel.entity.Payment;
import com.hostel.entity.RoomAllotment;
import com.hostel.entity.RoomManagement;
import com.hostel.reposistory.AdminRepo;
import com.hostel.reposistory.ContactRepo;
import com.hostel.reposistory.NightRequestRepo;
import com.hostel.reposistory.PaymentRepo;
import com.hostel.reposistory.Room_Allot_Repo;
import com.hostel.reposistory.cantidateRepo;
import com.hostel.reposistory.roomRepo;

@Service
public class ServiceClass implements ServiceInterface {

	@Autowired
	private AdminRepo ar;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private Room_Allot_Repo allot;

	@Override
	public Admin saveData(Admin admin) {
		String ePass = bCryptPasswordEncoder.encode(admin.getPass());
		admin.setPass(ePass);
		admin.setRole("ROLE_ADMIN");
		Admin a = ar.save(admin);
		return a;
	}

	@Override
	public Admin editById(long id) {

		Optional<Admin> aa = ar.findById(id);

		if (aa.isPresent()) {
			return aa.get();
		}
		return null;
	}
	
	
	public Admin updateSaveData(Admin admin) {
			Admin a = ar.save(admin);
		return a;
	}
	

	@Override
	public List<Admin> getAllData() {
		List<Admin> lst = ar.findAll();
		return lst;
	}

	// Conact
	@Autowired
	private ContactRepo cr;

	@Override
	public Contact saveContactData(Contact contact) {
		return cr.save(contact);
	}

//Save Candidate Data
	@Autowired
	private cantidateRepo cRepo;

	@Override
	public Candidate saveCandidateData(Candidate candidate) {
		// TODO Auto-generated method stub
		String pass=candidate.getPassword();
		String crypt=bCryptPasswordEncoder.encode(pass);
		candidate.setPassword(crypt);
		candidate.setRole("ROLE_CANDIDATE");

		Random random = new Random();
		Set<Integer> generatedNumbers = new HashSet<>();

		int randomNumber;

		// Loop until a unique 8-digit number is generated
		while (true) {
			// Generate an 8-digit random number
			randomNumber = 10000000 + random.nextInt(90000000);

			// Check if the number is already in the set
			if (!generatedNumbers.contains(randomNumber)) {
				// Add the unique number to the set
				generatedNumbers.add(randomNumber);
				break; // Exit the loop when a unique number is added
			}
		}
		candidate.setUniqueid(randomNumber);
		return cRepo.save(candidate);
	}

	@Override
	public List<Candidate> findAllCandidate() {
		List<Candidate> lst = cRepo.findAll();
		return lst;
	}

	@Override
	public Candidate candidateFindByID(long id) {

		Optional<Candidate> lst = cRepo.findById(id);

		if (lst.isPresent()) {
			return lst.get();
		}
		return null;
	}

	public Candidate saveCandidateUpdateData(Candidate candidate) {
		// TODO Auto-generated method stub
		candidate.setRole("ROLE_CANDIDATE");
		return cRepo.save(candidate);
	}

	@Override
	public void deleteCandidate(long id) {
		cRepo.deleteById(id);

	}

	//
	@Autowired
	private roomRepo rr;

	@Override
	public RoomManagement saveRoom(RoomManagement management) {
		// TODO Auto-generated method stub
		return rr.save(management);
	}

	@Override
	public List<RoomManagement> findAllRoom() {
		List<RoomManagement> lst = rr.findAll();
		return lst;
	}

	@Override
	public RoomManagement editRoom(long id) {
		Optional<RoomManagement> data = rr.findById(id);

		if (data.isPresent()) {
			return data.get();
		}
		return null;
	}

	@Override
	public void deleteRoom(long id) {
		rr.deleteById(id);

	}

	@Autowired
	private PaymentRepo pr;

//Save Info
	@Override
	public Payment savePaymentData(Payment payment) {
		// TODO Auto-generated method stub
		// Adding The remaning amount
		double amount = payment.getAmound();
		double paying_am = payment.getPaying_amount();
		double remaning = amount - paying_am;
		payment.setRemaning_amount(remaning);
		return pr.save(payment);
	}

	@Override
	public List<Payment> getAllPayement() {
		List<Payment> lst = pr.findAll();
		return lst;
	}

	@Override
	public Payment editPaymentById(long id) {
		Optional<Payment> lst = pr.findById(id);

		if (lst.isPresent()) {
			return lst.get();
		}
		return null;
	}

	@Override
	public void deletePaymentByID(long id) {
		pr.deleteById(id);

	}

	// update payment method
	public Payment updatePaymentData(Payment payment, Long id) {
		// Existing Amount
		Double existingPaidAmount = pr.findPayingAmountById(id);
		System.out.println(existingPaidAmount);

		// Total Amount
		double amount = payment.getAmound();
		// Currenty Paying Amount
		double paying_am = payment.getPaying_amount();

		double newPayingAmount = existingPaidAmount + paying_am;

		double newRemaingAmount = amount - newPayingAmount;
//New Paid Amount update;
		payment.setPaying_amount(newPayingAmount);
		// New Paid Remeinig Amount update;
		payment.setRemaning_amount(newRemaingAmount);

		return pr.save(payment);
	}
	
	
	//Room Allotment Data 
	@Autowired
	private Room_Allot_Repo allotRepo;

	@Override
	public RoomAllotment saveData(RoomAllotment allot) {
		// TODO Auto-generated method stub
		return allotRepo.save(allot);
	}

	@Autowired
	private NightRequestRepo nr;
	@Override
	public NightRequest saveRequest(NightRequest request) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		Candidate candidate = cRepo.findByEmail(email);
		
		int uID = candidate.getUniqueid();
		request.setuID(uID);
		// Find Room Number
		RoomAllotment allot1 = allot.findByUniqueId(uID);
		int room_no=allot1.getRoom_no();
		request.setRoom_no(room_no);
		request.setStatus("Pending");
		return nr.save(request);
	}

	@Override
	public List<NightRequest> getAllRequest() {
		NightRequest request = new NightRequest();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		Candidate candidate = cRepo.findByEmail(email);
		int uID = candidate.getUniqueid();		
		List<NightRequest> nn = nr.findByUid(uID);
		return nn;
	}

	@Override
	public void deleteNightRequest(int id) {
		nr.deleteById(null);
			
	}

	
	
	

}
