package com.kerimsamimi.issuemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kerimsamimi.issuemanagement.dto.IssueDto;
import com.kerimsamimi.issuemanagement.entity.User;
import com.kerimsamimi.issuemanagement.service.impl.UserServiceImpl;
import com.kerimsamimi.issuemanagement.util.ApiPaths;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = ApiPaths.UserCtrl.CTRL, description = "User APIs")
@CrossOrigin
public class AccountController {
	
	@Autowired
    private  UserServiceImpl userServiceImpl;
	
	@PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody User user){
//    	System.out.println(user.getUsername() + ' ' + user.getPassword());
    	return ResponseEntity.ok(userServiceImpl.login(user.getUsername(), user.getPassword()));
    }
	
	@PostMapping("/register")
	@ApiOperation(value="Register Operation", response = IssueDto.class)
    public ResponseEntity<User> register(@RequestBody User user){
    	System.out.println(user.getUsername() + ' ' + user.getPassword()+ ' ' + user.getPasswordConfirm());
    	return ResponseEntity.ok(userServiceImpl.saveUser(user));
    }

}
