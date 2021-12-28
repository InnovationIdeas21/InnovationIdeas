package com.saib.DTO;

import java.time.LocalDateTime;

import javax.persistence.Column;

import com.saib.models.Events;

public class EventDTO {
private String EventName;
	
	private String AgencyName;
	private String email;
	private LocalDateTime EventStartDate;
	private LocalDateTime EventEndDate;
	private String EventType;
	private String EventPurpose;
	private boolean fireable;
	private long EventId;
	
	public long getEventId() {
		return EventId;
	}
	public void setEventId(long eventId) {
		EventId = eventId;
	}
	public String getEventName() {
		return EventName;
	}
	public void setEventName(String eventName) {
		EventName = eventName;
	}
	public String getAgencyName() {
		return AgencyName;
	}
	public void setAgencyName(String agencyName) {
		AgencyName = agencyName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getEventStartDate() {
		return EventStartDate;
	}
	public void setEventStartDate(LocalDateTime eventStartDate) {
		EventStartDate = eventStartDate;
	}
	public LocalDateTime getEventEndDate() {
		return EventEndDate;
	}
	public void setEventEndDate(LocalDateTime eventEndDate) {
		EventEndDate = eventEndDate;
	}
	public String getEventType() {
		return EventType;
	}
	public void setEventType(String eventType) {
		EventType = eventType;
	}
	public String getEventPurpose() {
		return EventPurpose;
	}
	public void setEventPurpose(String eventPurpose) {
		EventPurpose = eventPurpose;
	}
	public boolean isFireable() {
		return fireable;
	}

	
	public static Events convert(EventDTO eventdto) {
		Events events = new Events ();
		events.setAgencyName(eventdto.getAgencyName());
		events.setEmail(eventdto.getEmail());
		events.setEventStartDate(eventdto.getEventStartDate());
		events.setEventEndDate(eventdto.getEventEndDate());
		events.setEventType(eventdto.getEventType());
		events.setEventPurpose(eventdto.getEventPurpose());
		events.setEventId(eventdto.getEventId());
		events.setFireable(false);
		return events;
		
		
		

		
	}
}
