package com.saib.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.saib.models.Agencies;
import com.saib.repository.AgencyRepository;
import com.saib.util.Results;

@Service
public class AgencyService {

	@Autowired
	AgencyRepository agencyRepository;
	
	public List<Agencies> getAllAgencies(){
		
		List<Agencies> list = agencyRepository.findAll();
		return list;
	}
	
	
	public String addAgencies(Agencies agencies)
	{
		String result = "";
		Agencies storedAgencies = agencyRepository.save(agencies);
		
		if(storedAgencies != null)
		{
			result = Results.SUCCESS;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Agencies not created");
		}
		
		return result;
	}
	
	
	
	/**public String deleteAgency(String agencyName)
	{
		String result="";
		try {
		agencyRepository.deleteAgency(agencyName);
		
		
			result=Results.SUCCESS;
			return result;
		}
		catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
		
		
	}
	
	
*/

	

}
