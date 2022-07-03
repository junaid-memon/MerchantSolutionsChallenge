package de.merchantsolutions.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login1")
	public String login (String username) {
		System.out.println("Hello");
		return "redirect:/registeration/save";
	}
}
