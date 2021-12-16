package com.woo.bo.controller;

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
