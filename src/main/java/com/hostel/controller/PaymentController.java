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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hostel.entity.Payment;
import com.hostel.reposistory.PaymentRepo;
import com.hostel.service.ServiceClass;

@Controller
@RequestMapping("/admin")
public class PaymentController {

	@Autowired
	private ServiceClass sc;

	@Autowired
	private PaymentRepo pp;

	@GetMapping("/adminFeeManagement")
	public String feeManagement(Model model) {
		List<Payment> paymentData = sc.getAllPayement();
		model.addAttribute("payment", paymentData);
		long remaningAmount = pp.totalRemaningAmount();
		model.addAttribute("RemaningAmount", remaningAmount);
		long recivedAmount = pp.totalRecivedAmount();
		model.addAttribute("RecivedAmount", recivedAmount);
		return "FeeManagement";
	}

	// Save Payment Data
	@PostMapping("/savePayment")
	public String savePaymentData(@ModelAttribute Payment payment,RedirectAttributes attributes) {
		Payment p = sc.savePaymentData(payment);
		if(p!=null) {
			attributes.addFlashAttribute("status", "Fee");
		}
		else {
			attributes.addFlashAttribute("status", "NotFee");
		}
		return "redirect:/admin/adminFeeManagement";
	}

	@GetMapping("/edit/PaymentById/{id}")
	public String editPaymentDetail(@PathVariable long id, Model model) {
		System.out.println(id);
		Payment data = sc.editPaymentById(id);
		model.addAttribute("paymentData", data);
		double remaningAmount = pp.findRemaingAmountById(id);
		System.out.println(remaningAmount);
		// long remaningAmount = pp.totalRemaningAmount();
		model.addAttribute("RemaningAmount", remaningAmount);

		return "EditPaymentDetails";
	}

	@PostMapping("/updatePayment")
	public String saveUpdateDetail(@RequestParam("id") Long id, @ModelAttribute Payment payment ,RedirectAttributes attributes) {
		Payment p = sc.updatePaymentData(payment, id);
		if(p!=null) {
			attributes.addFlashAttribute("status", "UFee");
		}
		else {
			attributes.addFlashAttribute("status", "UNotFee");
		}
		return "redirect:/admin/adminFeeManagement";
	}

	@GetMapping("/delete/PaymentById/{id}")
	public String deleteByID(@PathVariable long id) {
		sc.deletePaymentByID(id);
		return "redirect:/admin/adminFeeManagement";
	}

}
