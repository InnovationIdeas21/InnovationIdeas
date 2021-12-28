package com.saib.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Events {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="event_id")
	private long EventId;
	
	@Column(name="event_name")
	private String EventName;
	
	@Column(name="agency_name")
	private String AgencyName;
	
	@Column(name="email")
	private String email;

	@Column(name="event_startdate")
	private LocalDateTime EventStartDate;

	@Column(name="event_enddate")
	private LocalDateTime EventEndDate;
	
	@Column(name="event_type")
	private String EventType;

	@Column(name="event_purpose")
	private String EventPurpose;
	
	@Column(name="fireable")
	private boolean fireable;

	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Events(long eventId, String eventName, String agencyName, String email, LocalDateTime eventStartDate,
			LocalDateTime eventEndDate, String eventType, String eventPurpose, boolean fireable) {
		super();
		EventId = eventId;
		EventName = eventName;
		AgencyName = agencyName;
		this.email = email;
		EventStartDate = eventStartDate;
		EventEndDate = eventEndDate;
		EventType = eventType;
		EventPurpose = eventPurpose;
		this.fireable = fireable;
	}

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

	public void setFireable(boolean fireable) {
		this.fireable = fireable;
	}

	@Override
	public String toString() {
		return "Events [EventId=" + EventId + ", EventName=" + EventName + ", AgencyName=" + AgencyName + ", email="
				+ email + ", EventStartDate=" + EventStartDate + ", EventEndDate=" + EventEndDate + ", EventType="
				+ EventType + ", EventPurpose=" + EventPurpose + ", fireable=" + fireable + "]";
	}

}
