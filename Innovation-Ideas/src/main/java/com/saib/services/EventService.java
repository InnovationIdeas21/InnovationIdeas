package com.saib.services;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.saib.models.Events;
import com.saib.repository.EventRepository;
import com.saib.util.Results;

@Service
public class EventService {
	
	@Autowired
	EventRepository eventRepository;
	
	public List<Events> getAllEvents()
	{
		List<Events> list=eventRepository.findAll();
		return list;
	
		
	}


/**	 public List<Events> getEventsByType(String EventType){
			
			List<Events> events=eventRepository.findByEventType(EventType);
			return events;
		}

*/
	
	public String addEvent(Events events)
	{
		String result="";
		Events storedAccount=eventRepository.save(events);
		if(storedAccount!=null) {
			result=Results.SUCCESS;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account not created");
		}
		
		return result;
	}
	
	
	
	public String updateEvent(Events events, long EventId)
	{
		String result="";
		
		events.setEventId(EventId);
		Events updatedAccount=eventRepository.save(events);
		
		if(updatedAccount!=null)
		{
			result=Results.SUCCESS;
		}
		else
		{
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record was not updated");
			
		}
		return result;
		
	}
	
	public String deleteEvent(long EventId)
	{
		String result="";
		try {
		eventRepository.deleteById(EventId);
		
		
			result=Results.SUCCESS;
			return result;
		}
		catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
		
		
	}
	

}
