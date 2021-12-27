package com.saib.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.saib.models.Users;
import com.saib.repository.UserRepository;
import com.saib.util.Results;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public List<Users> getAllUsers()
	{
		List<Users> list=userRepository.findAll();
		return list;
	}
	
	
	public Users getUserbyUserId(long UserId)
	{
		Optional<Users> optional=userRepository.findById(UserId);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user with user Number:"+UserId+"doesn't exist");
		}
		
	}
	
	
	public String addUser(Users users)
	{
		String result="";
		Users storedUser=userRepository.save(users);
		if(storedUser!=null) {
			result=Results.SUCCESS;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user not created");
		}
		
		return result;
	}
	
	
	
	public String updateUser (Users users, long UserId)
	{
		String result="";
		
		users.setUserId(UserId);
		Users updatedUser=userRepository.save(users);
		
		if(updatedUser!=null)
		{
			result=Results.SUCCESS;
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record was not updated");
		}
		return result;	
	}
	
	
	
	public String deleteUser(long UserId)
	{
		String result="";
		try {
		userRepository.deleteById(UserId);
		
		
			result=Results.SUCCESS;
			return result;
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
		
	}



}

