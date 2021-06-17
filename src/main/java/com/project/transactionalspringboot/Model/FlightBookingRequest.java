package com.project.transactionalspringboot.Model;

import com.project.transactionalspringboot.Entity.PassengerInfo;
import com.project.transactionalspringboot.Entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {

	private PassengerInfo passengerInfo;

	private PaymentInfo paymentInfo;

}
