package com.hostel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hostel.entity.Candidate;
import com.hostel.entity.Payment;
import com.hostel.entity.RoomAllotment;
import com.hostel.reposistory.PaymentRepo;
import com.hostel.reposistory.Room_Allot_Repo;
import com.hostel.reposistory.cantidateRepo;

@Controller
@RequestMapping("/candidate")
public class CandidateDashboard2 {
	int UID;
	@Autowired
	private cantidateRepo cr;

	@Autowired
	private Room_Allot_Repo rr;

	@Autowired
	private PaymentRepo pr;

	@GetMapping("/candidateDashboard")
	public String candidateDashboard(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		Candidate candidate = cr.findByEmail(email);
		model.addAttribute("candidate_Data", candidate.getName());

		int uID = candidate.getUniqueid();
		UID = uID;

		// Find Room Number
		RoomAllotment allot = rr.findByUniqueId(uID);
		model.addAttribute("room_no", allot.getRoom_no());

		// Payment
		Payment payment = pr.findByEmail(uID);

		double amount = payment.getAmound();
		model.addAttribute("amount", amount);
		double paying_amount = payment.getPaying_amount();
		model.addAttribute("paying_amount", paying_amount);
		double remaning_amount = payment.getRemaning_amount();
		model.addAttribute("remaning_amount", remaning_amount);
		String date = payment.getDate();
		model.addAttribute("date", date);

		return "CandidateDashboard";
	}

	@GetMapping("/studFeeManagement")
	public String studFeeManagementt(Model model) {

		Payment payment = pr.findByEmail(UID);

		double amount = payment.getAmound();
		model.addAttribute("amount", amount);
		double paying_amount = payment.getPaying_amount();
		model.addAttribute("paying_amount", paying_amount);
		double remaning_amount = payment.getRemaning_amount();
		model.addAttribute("remaning_amount", remaning_amount);
		String date = payment.getDate();
		model.addAttribute("date", date);

		return "studFeeManagement";
	}

	@GetMapping("/studRoomManagement")
	public String studRoomManagementt(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		Candidate candidate = cr.findByEmail(email);
		model.addAttribute("candidate_Data", candidate.getName());

		int uID = candidate.getUniqueid();

		// Find Room Number
		RoomAllotment allot = rr.findByUniqueId(uID);
		model.addAttribute("room_no", allot.getRoom_no());
		return "studRoomManagement";
	}

}
