package com.saib.controllers;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.saib.config.ApiSucessPayload;
import com.saib.models.Events;
import com.saib.models.Users;
import com.saib.services.EventService;
import com.saib.services.UserService;
import com.saib.util.Results;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

		
		/*
		 *  GET - /users - Get me all details 
		 *  GET - /users/id - Get me details for a single user 
		 *  POST - /users - Creating a new user 
		 *  PUT - /users/id - Updating an existing account 
		 *  DELETE -/users/id - for deleting an account from db
		 *  
		 *  
		 */
	   @Autowired
	   UserService userService;
		
		@GetMapping()
		public ResponseEntity<ApiSucessPayload> getAllUsers()
		{
			List<Users> list=userService.getAllUsers();
			
			ApiSucessPayload payload=ApiSucessPayload.build(list, "Event Fetched", HttpStatus.OK);
			ResponseEntity<ApiSucessPayload> response=new ResponseEntity<ApiSucessPayload>(payload,HttpStatus.OK);
			
			return response;
			
		}
		
		@GetMapping("/{UserId}")
		public ResponseEntity<ApiSucessPayload> getUserbyUserId(@PathVariable long UserId)
		{
			Users users=userService.getUserbyUserId(UserId);
			
			ApiSucessPayload payload=ApiSucessPayload.build(users, "Success",HttpStatus.OK);
			ResponseEntity<ApiSucessPayload> response=new ResponseEntity<ApiSucessPayload>(payload,HttpStatus.OK);
			return response;
		}
		
		
		@PostMapping()
		public ResponseEntity<ApiSucessPayload> addusers(@RequestBody Users user) throws NoSuchAlgorithmException
		{
			ResponseEntity<ApiSucessPayload> response=null;
			System.out.println(user);
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");  
			messageDigest.update(user.getPassword().getBytes(),0, user.getPassword().length());  
			String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);  
			if (hashedPass.length() < 32) {
			   hashedPass = "0" + hashedPass; 
			}
			user.setPassword(hashedPass);
			String result=userService.addUser(user);
			if(result.equalsIgnoreCase(Results.SUCCESS))
			{
				ApiSucessPayload payload=ApiSucessPayload.build(result, "user created successfully", HttpStatus.CREATED);
				response=new ResponseEntity<ApiSucessPayload>(payload,HttpStatus.CREATED);
			}
			
			return response;
		
		}
		
		@PutMapping("/{UserId}")
		public ResponseEntity<ApiSucessPayload> updateUser(@RequestBody Users users, @PathVariable long UserId)
		{
			String result=userService.updateUser(users, UserId);
			ApiSucessPayload payload=ApiSucessPayload.build(result,result,HttpStatus.OK);
			ResponseEntity<ApiSucessPayload> response=new ResponseEntity<ApiSucessPayload>(payload, HttpStatus.OK);
			return response;
		}
		
		@DeleteMapping("/{UserId}")
		public ResponseEntity<ApiSucessPayload> deleteUser (@PathVariable long UserId)
		{
			String result=userService.deleteUser(UserId);
			ApiSucessPayload payload=ApiSucessPayload.build(result,result,HttpStatus.OK);
			ResponseEntity<ApiSucessPayload> response=new ResponseEntity<ApiSucessPayload>(payload, HttpStatus.OK);
			return response;
		}
		
		
	

}

