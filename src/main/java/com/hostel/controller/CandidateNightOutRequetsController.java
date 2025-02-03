package com.hostel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hostel.entity.NightRequest;
import com.hostel.service.ServiceClass;

@Controller
@RequestMapping("/candidate")
public class CandidateNightOutRequetsController {

	@Autowired
	private ServiceClass sc;

	@GetMapping("/studNightOutApprovalManagement")
	public String studNightOutApprovalManagementt(Model model) {
		List<NightRequest> lst = sc.getAllRequest();
		model.addAttribute("request", lst);
		return "studNightOutApprovalManagement";
	}

	@PostMapping("/nightOutRequestion")
	public String saveNightRequest(@ModelAttribute NightRequest request, Model model,RedirectAttributes attributes) {
		NightRequest nn = sc.saveRequest(request);
		if(nn!=null) {
			attributes.addFlashAttribute("status", "NightOut");
		}
		else {
			attributes.addFlashAttribute("status", "NotNightOut");
		}
		
		return "redirect:/candidate/studNightOutApprovalManagement";
	}

	
}
