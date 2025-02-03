package com.hostel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hostel.entity.Candidate;
import com.hostel.service.ServiceClass;

@Controller
@RequestMapping("/admin")
public class CandidateController {
	@Autowired
	private ServiceClass sc;

	@GetMapping("/adminStudManagement")
	public String studManagement(Model model) {

		List<Candidate> lst = sc.findAllCandidate();
		model.addAttribute("candidate_data", lst);
		return "StudentManagement";
	}
//Save Candidate

	@PostMapping("/saveCandidate")
	public String saveCandidateData(@ModelAttribute Candidate candidate,RedirectAttributes attributes) {
		
		Candidate c = sc.saveCandidateData(candidate);
		
		if(c!=null) {
			 attributes.addFlashAttribute("status", "UserAdd");
		        attributes.addFlashAttribute("uid", c.getUniqueid());
		}
		else {
			attributes.addFlashAttribute("status", "UserNotAdd");
		}
		
		
		return "redirect:/admin/adminStudManagement";
	}

	@GetMapping("/edit/candidate_data/{id}")
	public String editCandidate(@PathVariable int id, Model model) {
		Candidate data = sc.candidateFindByID(id);
		model.addAttribute("editData", data);
		return "editCandidateDetail";
	}

	@PostMapping("/saveUpdateCandidate")
	public String saveUpdateCandidate(@ModelAttribute Candidate candidate,RedirectAttributes attributes) {

		Candidate c = sc.saveCandidateUpdateData(candidate);
		if(c!=null) {
			attributes.addFlashAttribute("status", "Update");
		}
		else {
			attributes.addFlashAttribute("status", "NotUpdate");
		}
		return "redirect:/admin/adminStudManagement";
	}

	@GetMapping("/delete/candidate_data/{id}")
	public String deleteCandidate(@PathVariable long id) {
		sc.deleteCandidate(id);
		return "redirect:/admin/adminStudManagement";
	}
}
