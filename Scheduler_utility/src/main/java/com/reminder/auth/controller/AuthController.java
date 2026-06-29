package com.reminder.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.reminder.auth.dto.LoginRequest;
import com.reminder.auth.dto.RegisterRequest;
import com.reminder.auth.entity.User;
import com.reminder.auth.service.AuthService;
import com.reminder.common.dto.ResponseData;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

//    @PostMapping("/register")
//    public String register(
//            @RequestBody RegisterRequest request) {
//
//        return authService.register(request);
//    }
    
    @PostMapping("/register")
    public ResponseData register(@RequestBody RegisterRequest request) {

        String result = authService.register(request);

        ResponseData response = new ResponseData();

        if ("Email already exists".equals(result)) {
            response.setResponseStatus("failed");
            response.setResponseMessage(result);
        } else {
            response.setResponseStatus("success");
            response.setResponseMessage(result);
        }


        return response;
    }
    

    
    
//    @PostMapping("/login")
//    public String login(
//            @RequestBody LoginRequest request) {
//    	
//
//        return authService.login(request);
//    }
    
    @PostMapping("/login")
    public ResponseData login(
            @RequestBody LoginRequest request) {
    	String result = authService.login(request);
        ResponseData response = new ResponseData();
        if ("Invalid Email".equals(result)) {
            response.setResponseStatus("failed");
            response.setResponseMessage(result);
        }else if("Invalid Password".equals(result)){ 
        	response.setResponseStatus("failed");
        	response.setResponseMessage(result);
        }
        else {
            response.setResponseStatus("success");
            response.setResponseMessage(result);
        }


        return response;
    }
}