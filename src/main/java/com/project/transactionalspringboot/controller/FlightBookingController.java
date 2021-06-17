package com.project.transactionalspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.transactionalspringboot.Model.FlightBookingAcknowledgement;
import com.project.transactionalspringboot.Model.FlightBookingRequest;
import com.project.transactionalspringboot.Service.FlightBookingService;

@RestController
public class FlightBookingController {

	@Autowired
	private FlightBookingService flightBookingService;

	@PostMapping(value = "/bookFlightTicket", produces = MediaType.APPLICATION_JSON_VALUE)
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest flightBookingRequest) {

		return flightBookingService.bookFlightTicket(flightBookingRequest);
	}
}
