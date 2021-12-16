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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.woo.bo.data.entity.WooUser;
import com.woo.bo.service.api.UserService;

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

    @Value("${application.host}")
    private String appRoot;

    //build create employee REST API
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Creates a new Customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK - Found User Created successfully, returns the http location header, indicating the url of the customer"),
            @ApiResponse(code = 301, message = "forbidden"),
            @ApiResponse(code = 404, message = "SERVICES_NOT_FOUND - It occurs when User could not save in the DB due duplication or other validations"),
            @ApiResponse(code = 410, message = "password cannot be empty"),
            @ApiResponse(code = 411, message = "User with username given already exist"),
            @ApiResponse(code = 414, message = "Sponsor is not active or does not exist."),
            @ApiResponse(code = 415, message = "User is not an active user"),
            @ApiResponse(code = 416, message = "Product does not exist"),
            @ApiResponse(code = 429, message = "reCaptcha was not successfully validated"),
            @ApiResponse(code = 500, message = "500 - 599 operation could not completed - please Contact support")
    })
    @PostMapping
    public ResponseEntity save(@Valid @RequestBody WooUser wooUser) {
        long userId = userService.save(wooUser);
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(LOCATION,   appRoot + ROOT_PATH + userId)
                .build();

@RestController
@RequestMapping("/api/woo_user")
public class WooUserController {
    @Autowired
    private UserService userService;


    //build create employee REST API
    @Operation(summary = "Add a new contact", description = "", tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created",
                    content = @Content(schema = @Schema(implementation = WooUser.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "User already exists")})
    @PostMapping(value = "/", consumes = {"application/json"})
    public ResponseEntity<WooUser> saveUser(
            @Parameter(description = "User to add. Cannot null or empty.",
                    required = true, schema = @Schema(implementation = WooUser.class))
            @Valid @RequestBody WooUser wooUser) {

        return new ResponseEntity<WooUser>(userService.saveUser(wooUser), HttpStatus.CREATED);

    }

}
