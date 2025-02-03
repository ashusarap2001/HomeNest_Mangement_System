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

import com.hostel.entity.RoomManagement;
import com.hostel.service.ServiceClass;

@Controller
@RequestMapping("/admin")
public class RoomController {
	
	@Autowired
	private ServiceClass sc;
	
//	@Autowired
//	private roomRepo rr;
	
	@GetMapping("/adminRoomManagement")
	public String roomManagement(Model model) {

		List<RoomManagement> lst = sc.findAllRoom();
		model.addAttribute("roomData", lst);
		return "RoomManagement";
	}

	@PostMapping("/saveRoom")
	public String saveRoomData(@ModelAttribute RoomManagement management,RedirectAttributes attributes) {
		RoomManagement r= sc.saveRoom(management);
		
		if(r!=null) {
			attributes.addFlashAttribute("status", "RoomAdd");
		}
		else {
			attributes.addFlashAttribute("status", "RoomNotAdd");
		}
		
		return "redirect:/admin/adminRoomManagement";
	}

	@GetMapping("/roomEdit/{id}")
	public String editRoom(@PathVariable long id, Model model) {
		RoomManagement rr = sc.editRoom(id);
		model.addAttribute("roomData", rr);

		return "editRoomData";
	}

	@PostMapping("/saveEditRoom")
	public String editData(@ModelAttribute RoomManagement management) {
		sc.saveRoom(management);
		return "redirect:/admin/adminRoomManagement";
	}

	@GetMapping("/roomDelete/{id}")
	public String deleteRoom(@PathVariable long id,RedirectAttributes attributes) {
		
			
		if(id>0) {
			sc.deleteRoom(id);
			attributes.addFlashAttribute("status", "DeleteRoom");
		}
		else {
			attributes.addFlashAttribute("status", "NotDeleteRoom");
		}
			

		return "redirect:/admin/adminRoomManagement";
	}


}
