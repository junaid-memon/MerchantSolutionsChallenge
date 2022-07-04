package de.merchantsolutions.challenge.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.merchantsolutions.challenge.service.UserService;

@RestController
@RequestMapping("/register")
public class UserController {

	private static UserService userService;

	UserController(UserService userService) {
		UserController.userService = userService;
	}

	@PostMapping("/save")
	public String saveUser(@RequestParam String username) {
		System.out.println("hello");
		userService.saveUser();
		return "redirect:/save?success";
	}
}
