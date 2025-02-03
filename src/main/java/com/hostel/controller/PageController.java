package com.hostel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/adminRegistration")
	public String adminRegistration() {

		return "adminRegistration";
	}

	@GetMapping("/aboutPage")
	public String aboutPage() {
		return "about";
	}

	@GetMapping("/contactPage")
	public String contactPage() {
		return "contact";
	}

}
