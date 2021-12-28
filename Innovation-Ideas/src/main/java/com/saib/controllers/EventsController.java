package com.saib.controllers;
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
import org.springframework.web.bind.annotation.RestController;

import com.saib.DTO.EventDTO;
import com.saib.config.ApiSucessPayload;
import com.saib.models.Events;
import com.saib.services.EventService;
import com.saib.util.Results;

@RestController
public class EventsController {
	/*
	 *  GET - /events - Get me all details 
	 *  GET - /events/id - Get me details for a single event
	 *  POST - /events - Creating a new event
	 *  PUT - /events/id - Updating an existing event
	 *  DELETE -/events/id - for deleting an event from db
	 *  
	 *  
	 */
	
	@Autowired
	EventService eventService;
	
	@GetMapping("/events")
	public ResponseEntity<ApiSucessPayload> getAllEvents()
	{
		List<Events> list=eventService.getAllEvents();
		
		ApiSucessPayload payload=ApiSucessPayload.build(list, "Event Fetched", HttpStatus.OK);
		ResponseEntity<ApiSucessPayload> response=new ResponseEntity<ApiSucessPayload>(payload,HttpStatus.OK);
		
		return response;
		
	}
	
	
/**	@GetMapping("/events/EventType/{EventType}")
	public ResponseEntity<ApiSucessPayload> getEventsByType(@PathVariable String EventType)
	{
		List<Events> list =eventService.getEventsByType(EventType);
		
		ApiSucessPayload payload=ApiSucessPayload.build(list, "Success",HttpStatus.OK);
		ResponseEntity<ApiSucessPayload> response=new ResponseEntity<ApiSucessPayload>(payload,HttpStatus.OK);
		return response;
	}
	
	*/
	@PostMapping("/events")
	public ResponseEntity<ApiSucessPayload> addEvent(@RequestBody EventDTO events)
	{
		ResponseEntity<ApiSucessPayload> response=null;
		System.out.println(events);
		String result=eventService.addEvent(EventDTO.convert(events));
		if(result.equalsIgnoreCase(Results.SUCCESS))
		{
			ApiSucessPayload payload=ApiSucessPayload.build(result, "Event created successfully", HttpStatus.CREATED);
			response=new ResponseEntity<ApiSucessPayload>(payload,HttpStatus.CREATED);
		}
		
		return response;
	
	}
	
	
	@PutMapping("/events/{EventId}")
	public ResponseEntity<ApiSucessPayload> updateEvent(@RequestBody Events events, @PathVariable long EventId)
	{
		String result=eventService.updateEvent(events, EventId);
		ApiSucessPayload payload=ApiSucessPayload.build(result,result,HttpStatus.OK);
		ResponseEntity<ApiSucessPayload> response=new ResponseEntity<ApiSucessPayload>(payload, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/events/{EventId}")
	public ResponseEntity<ApiSucessPayload> deleteEvent(@PathVariable long EventId)
	{
		String result=eventService.deleteEvent(EventId);
		ApiSucessPayload payload=ApiSucessPayload.build(result,result,HttpStatus.OK);
		ResponseEntity<ApiSucessPayload> response=new ResponseEntity<ApiSucessPayload>(payload, HttpStatus.OK);
		return response;
	}
	
}
