package com.woo.bo.data.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;


@Entity
@Table(name="wooUser")
@Data
public class WooUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	@NotNull
	@NotBlank(message="Please enter username")
	private String userName;
	@Valid
	private String password;
	@NotNull
	@NotBlank(message="Please enter your phone number")
	private String mobilePhone;
	private String walletAddress;
	@Email
	@NotEmpty
	private String email;	
	private String role="user";
	
	
	
}