package de.merchantsolutions.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.merchantsolutions.challenge.repository.ProductRepository;

/**
 * @author memon
 * 
 *         Login Controller class, when the user is authorized, this class show
 *         the contents of purchase page and returns error if the username and
 *         password is invalid
 * 
 */

@Controller
public class LoginController {

	private ProductRepository productRepository;

	LoginController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {

		if (error != null) {
			model.addAttribute("error", "Your username and password is invalid.");
		}
		if (logout != null) {
			model.addAttribute("message", "You have been logged out successfully.");
		}

		return "login";
	}

	@GetMapping("/purchase")
	public String purchase(Model model) {

		model.addAttribute("products", productRepository.findAll());

		return "purchase";
	}
}
