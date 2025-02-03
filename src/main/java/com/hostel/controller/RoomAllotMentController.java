package com.hostel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hostel.entity.RoomAllotment;
import com.hostel.service.ServiceClass;

@Controller
@RequestMapping("/admin")
public class RoomAllotMentController {

	@Autowired
	private ServiceClass sc;
	@GetMapping("/roomAllot")
	public String roomAllot() {
		return "roomAllot";
	}
	
	@PostMapping("/saveRoomAllotData")
	public String allotRoom(@ModelAttribute RoomAllotment allotment,Model model,RedirectAttributes attributes) {
		RoomAllotment a= sc.saveData(allotment);
		if(a!=null) {
			attributes.addFlashAttribute("status", "Allot");
		}
		else {
			attributes.addFlashAttribute("status", "NotAllot");
		}
		
		return "redirect:/admin/roomAllot";
	}
}
