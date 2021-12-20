package com.woo.bo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.woo.bo.data.entity.WooUser;
import com.woo.bo.service.api.UserService;

import java.util.List;

import javax.validation.Valid;

@Api(tags = "User Endpoint")
@RestController
@RequestMapping("/api/woo_user")
@Validated
@Slf4j
public class WooUserController {

    private static final String ROOT_PATH = "/api/woo_user";
    private static final String LOCATION = "Location";

    @Autowired
    private UserService userService;

    //@Value("${application.host}")
    private String appRoot;

    //build CREATE woo User REST API
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Creates a new Woo User")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK - Found User Created successfully, returns the http location header, indicating the url of the customer"),
            @ApiResponse(code = 301, message = "forbidden"),
            @ApiResponse(code = 404, message = "SERVICES_NOT_FOUND - It occurs when User could not save in the DB due duplication or other validations"),
            @ApiResponse(code = 410, message = "password cannot be wooUserty"),
            @ApiResponse(code = 411, message = "User with username given already exist"),
            @ApiResponse(code = 414, message = "Sponsor is not active or does not exist."),
            @ApiResponse(code = 415, message = "User is not an active user"),
            @ApiResponse(code = 416, message = "Product does not exist"),
            @ApiResponse(code = 429, message = "reCaptcha was not successfully validated"),
            @ApiResponse(code = 500, message = "500 - 599 operation could not completed - please Contact support")
    })
    @PostMapping()
    public ResponseEntity save(@Valid @RequestBody WooUser wooUser) {
        long userId = userService.save(wooUser);
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(LOCATION,   appRoot + ROOT_PATH + userId)
                .build();
    }
    
    //build GET woo User  REST API
    
    @ApiOperation(value = "Get All Users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK - Found User Created successfully, returns the http location header, indicating the url of the customer"),
            @ApiResponse(code = 301, message = "forbidden"),
            @ApiResponse(code = 404, message = "SERVICES_NOT_FOUND - It occurs when User could not save in the DB due duplication or other validations"),
            @ApiResponse(code = 410, message = "password cannot be wooUserty"),
            @ApiResponse(code = 411, message = "User with username given already exist"),
            @ApiResponse(code = 414, message = "Sponsor is not active or does not exist."),
            @ApiResponse(code = 415, message = "User is not an active user"),
            @ApiResponse(code = 416, message = "Product does not exist"),
            @ApiResponse(code = 429, message = "reCaptcha was not successfully validated"),
            @ApiResponse(code = 500, message = "500 - 599 operation could not completed - please Contact support")
    })
    @GetMapping()
    public List<WooUser> getAllWooUsers(){
   	 return  userService.getAllUsers();
    }
    
    // GET user by Id
    @ApiOperation(value = "Get woo User by Id ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK - Found User Created successfully, returns the http location header, indicating the url of the customer"),
            @ApiResponse(code = 301, message = "forbidden"),
            @ApiResponse(code = 404, message = "SERVICES_NOT_FOUND - It occurs when User could not save in the DB due duplication or other validations"),
            @ApiResponse(code = 410, message = "password cannot be wooUserty"),
            @ApiResponse(code = 411, message = "User with username given already exist"),
            @ApiResponse(code = 414, message = "Sponsor is not active or does not exist."),
            @ApiResponse(code = 415, message = "User is not an active user"),
            @ApiResponse(code = 416, message = "Product does not exist"),
            @ApiResponse(code = 429, message = "reCaptcha was not successfully validated"),
            @ApiResponse(code = 500, message = "500 - 599 operation could not completed - please Contact support")
    })
    @GetMapping("/{id}")
    public ResponseEntity<WooUser> getEmployeeByID(@PathVariable("id") Long id) {
   	 return new ResponseEntity<WooUser>(userService.getUserById(id),HttpStatus.OK);
    }
    
    //update User by UserId
    @ApiOperation(value = "Update Woo user By Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK - Found User Created successfully, returns the http location header, indicating the url of the customer"),
            @ApiResponse(code = 301, message = "forbidden"),
            @ApiResponse(code = 404, message = "SERVICES_NOT_FOUND - It occurs when User could not save in the DB due duplication or other validations"),
            @ApiResponse(code = 410, message = "password cannot be wooUserty"),
            @ApiResponse(code = 411, message = "User with username given already exist"),
            @ApiResponse(code = 414, message = "Sponsor is not active or does not exist."),
            @ApiResponse(code = 415, message = "User is not an active user"),
            @ApiResponse(code = 416, message = "Product does not exist"),
            @ApiResponse(code = 429, message = "reCaptcha was not successfully validated"),
            @ApiResponse(code = 500, message = "500 - 599 operation could not completed - please Contact support")
    })
    @PutMapping("/{id}")
    public ResponseEntity<WooUser> updateWooUser(@PathVariable("id") Long id,@RequestBody WooUser wooUser){
   	
 
   	 return new ResponseEntity<WooUser>(userService.updateWooUserById(id, wooUser), HttpStatus.OK);
   	 
    }
}