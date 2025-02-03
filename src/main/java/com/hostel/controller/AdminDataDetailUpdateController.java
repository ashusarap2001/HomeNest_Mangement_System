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
import org.springframework.web.bind.annotation.RequestParam;
import com.hostel.entity.Admin;
import com.hostel.service.ServiceClass;

@Controller
@RequestMapping("/admin")
public class AdminDataDetailUpdateController {
	
String pass;
	@Autowired
	private ServiceClass sc;

	@GetMapping("/AdminSettingPage")
	public String getAminData(Model model) {
		List<Admin> lst = sc.getAllData();
		model.addAttribute("adminData", lst);
		return "AdminSettingPage";
	}

	@GetMapping("/edit/adminProfil/{id}")
	public String editadminProfil(@PathVariable long id, Model model) {

		Admin aa = sc.editById(id);
		pass=aa.getPass();
		

		model.addAttribute("data", aa);
		return "adminEditPage";

	}
	
	@PostMapping("/update/adminProfil" )
	public String updateProfil(@ModelAttribute Admin admin, @RequestParam("pass")String pass) {
		sc.saveData(admin);
		return "redirect:/admin/AdminSettingPage"; 
	}
}
