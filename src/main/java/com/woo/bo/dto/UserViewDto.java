package com.woo.bo.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class UserViewDto {
	
	// validate it  
	// move dto to service
	private long userId;
	private String userName;
	private String mobilePhone;
	private String walletAddress;
	private String email;
	private long sponserId;
	private String role="user";

}
