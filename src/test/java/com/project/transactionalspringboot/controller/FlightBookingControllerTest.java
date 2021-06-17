package com.project.transactionalspringboot.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.project.transactionalspringboot.Entity.PassengerInfo;
import com.project.transactionalspringboot.Entity.PaymentInfo;
import com.project.transactionalspringboot.Model.FlightBookingAcknowledgement;
import com.project.transactionalspringboot.Model.FlightBookingRequest;
import com.project.transactionalspringboot.Service.FlightBookingService;

@WebMvcTest(controllers = FlightBookingController.class)
public class FlightBookingControllerTest {

	@Autowired
	private MockMvc mockmvc;

	@MockBean
	private FlightBookingService flightBookingService;

	// The pattern of DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.US) is MMM d,yyyy

	@Test
	@DisplayName("Should book Flight Ticket Successfully")
	public void bookFlightTicket() throws Exception {

		DateFormat formatter = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
		Date sd_correct = formatter.parse("Jan 01, 2021");
		FlightBookingAcknowledgement flightBookingAcknowledgement = new FlightBookingAcknowledgement("SUCCESS", 3000.0,
				"68495866",
				new PassengerInfo(25L, "Ritika", "ritika@gmail.com", "Lucknow", "Delhi", sd_correct, "4.0 PM", "6.0 PM",
						3000.0, TimeZone.getTimeZone("2021-01-01"), TimeZone.getTimeZone("2021-01-01")));

		Mockito.when(flightBookingService.bookFlightTicket(getFlightBookingRequest()))
				.thenReturn(flightBookingAcknowledgement);
		mockmvc.perform(MockMvcRequestBuilders.post("/bookFlightTicket").contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.source", is("Lucknow")));

	}

	private FlightBookingRequest getFlightBookingRequest() throws ParseException {

		DateFormat formatter = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
		Date sd_correct = formatter.parse("Jan 01, 2021");
		FlightBookingRequest req = new FlightBookingRequest();

		PassengerInfo passengerInfo = new PassengerInfo();

		PaymentInfo paymentInfo = new PaymentInfo();
		passengerInfo.setArrivalTime("6.0 PM");
		passengerInfo.setDestination("Delhi");
		passengerInfo.setEmail("ritika@gmail.com");
		passengerInfo.setEndDate(TimeZone.getTimeZone("2021-01-01"));
		passengerInfo.setFare(3000.0);
		passengerInfo.setName("Ritika");
		passengerInfo.setPassengerId(25L);
		passengerInfo.setPickupTime("4.0 PM");
		passengerInfo.setSource("Lucknow");
		passengerInfo.setStartDate(TimeZone.getTimeZone("2021-01-01"));
		passengerInfo.setTravelDate(sd_correct);
		paymentInfo.setAccountNo("acc3");
		paymentInfo.setAmount(3000.0);
		paymentInfo.setCardType("DEBIT");
		paymentInfo.setPassengerId(25L);
		paymentInfo.setPaymentId("402881867a190074017a1a41742a0002");
		req.setPassengerInfo(passengerInfo);
		req.setPaymentInfo(paymentInfo);
		return req;
	}
}
