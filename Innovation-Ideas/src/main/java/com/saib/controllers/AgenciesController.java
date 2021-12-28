package com.saib.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.saib.config.ApiSucessPayload;
import com.saib.models.Agencies;
import com.saib.services.AgencyService;
import com.saib.util.Results;


@RestController
public class AgenciesController {
		/*
		 * Get - /Agencies - Get me all Agencies details
		 * Post - /Agencies - Creating a new Agencie profile
		 * Put 
		 */
		
		@Autowired
		AgencyService agencyService;
		
		@GetMapping("/agencies")
		public ResponseEntity<ApiSucessPayload> getAllAgencies()
		{
			List<Agencies> list = agencyService.getAllAgencies();
			
			ApiSucessPayload payload = ApiSucessPayload.build(list, "Agencies Fetched", HttpStatus.OK);
			ResponseEntity<ApiSucessPayload> response = new ResponseEntity<ApiSucessPayload>(payload,HttpStatus.OK);
			
			return response;
		}
		
		@PostMapping("/agencies")
		public ResponseEntity<ApiSucessPayload> addAgencies(@RequestBody Agencies agencies)
		{
			ResponseEntity<ApiSucessPayload> response=null;
			System.out.println(agencies);
			String result=agencyService.addAgencies(agencies);
			if(result.equalsIgnoreCase(Results.SUCCESS))
			{
				ApiSucessPayload payload=ApiSucessPayload.build(result, "Agencies created successfully", HttpStatus.CREATED);
				response=new ResponseEntity<ApiSucessPayload>(payload,HttpStatus.CREATED);
			}
			
			return response;
		
		}


		
		
	}


