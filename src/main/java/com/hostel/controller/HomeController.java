package com.hostel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.hostel.entity.Admin;
import com.hostel.entity.Contact;
import com.hostel.service.ServiceClass;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}

	@Autowired
	private ServiceClass sc;

	@PostMapping("/saveAdminData")
	public String saveAdmin(@ModelAttribute Admin admin) {
		Admin ad = sc.saveData(admin);
		return "index";
	}

	//
	@PostMapping("/saveConact")
	public String saveContact(@ModelAttribute Contact contact, HttpServletRequest request, Model model,RedirectAttributes redirectAttributes) {

		Contact c = sc.saveContactData(contact);

		  if (c != null) {
		        redirectAttributes.addFlashAttribute("status", "Message Send SuccessFully...");
		    } else {
		        redirectAttributes.addFlashAttribute("status", "Message Send UNSuccessFully...");
		    }

		    return "redirect:/"; 
	}

}
