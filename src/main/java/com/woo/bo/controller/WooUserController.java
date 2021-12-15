package com.woo.bo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.woo.bo.UserEntity.WooUser;
import com.woo.bo.service.UserService;

@RestController
@RequestMapping	("/woo_user")
public class WooUserController {
	@Autowired
	private UserService userService;
 
 
 //build create employee REST API
 @PostMapping()
 public ResponseEntity<WooUser> saveEmployee(@RequestBody WooUser wooUser){
	 
	return new ResponseEntity<WooUser>(userService.saveUser(wooUser), HttpStatus.CREATED);	 
 }

}
