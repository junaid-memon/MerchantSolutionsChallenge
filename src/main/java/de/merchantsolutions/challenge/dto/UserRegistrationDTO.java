package de.merchantsolutions.challenge.dto;

import lombok.Data;

@Data
public class UserRegistrationDTO {

	private long userID;
	private String username;
	private String password;
	private String userRole;

}
