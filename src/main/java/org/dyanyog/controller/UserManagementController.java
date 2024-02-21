package org.dyanyog.controller;


import org.dyanyog.services.LoginServiceImpl;
import org.dyanyog.services.UserManagementServiceImpl;
import org.dyanyog.dto.LoginRequest;
import org.dyanyog.dto.LoginResponse;
import org.dyanyog.dto.User;
import org.dyanyog.dto.UserRequest;

import org.dyanyog.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagementController {

	@Autowired
	UserManagementServiceImpl userservice;
	
	@PostMapping(path= "/auth/user", consumes = {"application/json" , "application/xml"}, 
			produces = {"application/json" , "application/xml"})
	public UserResponse addUpdateUser(@RequestBody UserRequest request)
	{
		return userservice.addUser(request);
	}
	@GetMapping(path="/auth/user/{userId}")
	public User getSingleUser(@PathVariable long userId)
	{
		return userservice.getSingleUser(userId);
		
	}
	
	@DeleteMapping(path="/auth/user/delete/{userId}")
	public String deleteuser(@PathVariable Long userId)
	{
		return userservice.deleteuser(userId);
		
	}
	
	@PostMapping(path="/auth/user/update/{userId}",
			 consumes = {"application/json","application/xml"},
		      produces = {"application/json","application/xml"})
	public UserResponse UpdateUser(@RequestBody UserRequest userRequest,@PathVariable Long userId)
	{
		return userservice.UpdateUser(userId, userRequest);
	}
	@Autowired
	LoginServiceImpl loginService;
	@GetMapping(
			path="/auth/val",consumes= {"application/json","application/xml"},produces = {"application/json","application/xml"})
			
			public LoginResponse validate(@RequestBody LoginRequest loginRequest) {
		return loginService.validate(loginRequest);
		
	}
	
}