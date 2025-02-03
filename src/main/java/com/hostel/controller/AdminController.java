package com.hostel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hostel.entity.Admin;
import com.hostel.entity.NightRequest;
import com.hostel.reposistory.AdminRepo;
import com.hostel.reposistory.NightRequestRepo;
import com.hostel.reposistory.PaymentRepo;
import com.hostel.reposistory.cantidateRepo;
import com.hostel.reposistory.roomRepo;
import com.hostel.service.ServiceClass;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private cantidateRepo ar;

	@Autowired
	private roomRepo rr;

	@Autowired
	private PaymentRepo pp;
	
	@Autowired
	private AdminRepo adminRepo;
	@GetMapping("/adminDashboard")
	public String aDashboard(Model model) {
		long ad = ar.countIdNative();
		model.addAttribute("count", ad);
		
		long allRoomCount=rr.countIdRoomNative();
		model.addAttribute("allRommCount", allRoomCount);
		
		long roomAva = rr.countAvailableRoom();
		model.addAttribute("roomCount", roomAva);
		
		long roomOcu = rr.countOccupiedRoom();
		model.addAttribute("roomOcu", roomOcu);
		
		long remaningAmount=pp.totalRemaningAmount();
		model.addAttribute("RemaningAmount", remaningAmount);
		long recivedAmount=pp.totalRecivedAmount();
		model.addAttribute("RecivedAmount", recivedAmount);
		
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		String email=authentication.getName();
		
		Admin a =adminRepo.findByEmail(email);
		model.addAttribute("Admin_Name", a.getName());
	
		return "AdminDashbord";
	}

	@GetMapping("/adminReportManagement")
	public String reportManagement(Model model) {
		long ad = ar.countIdNative();
		model.addAttribute("count", ad);
		
		long roomCount = rr.countIdRoomNative();
		model.addAttribute("roomCount", roomCount);
		
		long recivedAmount=pp.totalRecivedAmount();
		model.addAttribute("RecivedAmount", recivedAmount);
		
		return "HostelReportManagement";
	}
@Autowired
private NightRequestRepo nr;
	@GetMapping("/lateNightApproval")
	public String lateNightApproval(Model model) {

		List<NightRequest> allRequest=nr.findAll();
		model.addAttribute("allRequest", allRequest);
		return "LateNigthApproval";
	}
	
	@GetMapping("/acceptByID/{id}")
	public String acceptbyId(@PathVariable int id) {
		nr.updateStatusToAcceptById(id);
		return "redirect:/admin/lateNightApproval";
	}

	@GetMapping("/rejectByID/{id}")
	public String rejectbyId(@PathVariable int id) {
		nr.updateStatusToRejectById(id);
		return "redirect:/admin/lateNightApproval";
	}

	
}
