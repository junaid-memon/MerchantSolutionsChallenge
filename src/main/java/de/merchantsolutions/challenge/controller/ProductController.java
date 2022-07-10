package de.merchantsolutions.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.merchantsolutions.challenge.model.Product;
import de.merchantsolutions.challenge.service.PriceValidationService;
import de.merchantsolutions.challenge.service.ProductService;

/**
 * @author memon
 * 
 *         Product Controller class, which validates the submitted price and
 *         also registers new product
 * 
 */

@Controller
public class ProductController {

	@Autowired
	private PriceValidationService priceValidationService;

	@Autowired
	private ProductService productService;

	/*
	 * getPriceValidation method returns the status if the given price matches the
	 * actual price of the product or not.
	 * 
	 */

	@PostMapping("/purchaseItem")
	public String getPriceValidation(@RequestParam("givenPrice") Double givenPrice,
			@RequestParam("productName") String productName, Model model) {

		ResponseEntity<String> validatePrice = priceValidationService.validatePrice(givenPrice, productName);

		if (validatePrice.getBody().equals("failed")) {
			model.addAttribute("failed", "The submitted price is less than the actual price, hence purchasing failed");
			model.addAttribute("purchaseItem", "return to purchase page");
		} else {
			model.addAttribute("purchased", "The item has been succesfully purchased");
			model.addAttribute("purchaseItem", "return to purchase page");
		}

		return "purchase";
	}

	@GetMapping("/register")
	public String register(String success, Model model) {
		if (success != null) {
			model.addAttribute("success", "Product Registered Successfull");
		}
		return "register";

	}

	/*
	 * registerProduct method registers the new product into the repository
	 * 
	 */

	@PostMapping("registerProduct")
	public String registerProduct(@RequestParam("givenPrice") Double price,
			@RequestParam("productName") String productName) {

		Product product = new Product();
		product.setName(productName);
		product.setPrice(price);
		productService.update(product);

		return "redirect:/register?success";
	}

}
