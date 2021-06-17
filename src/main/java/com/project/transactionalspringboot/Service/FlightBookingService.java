package com.project.transactionalspringboot.Service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.transactionalspringboot.Entity.PassengerInfo;
import com.project.transactionalspringboot.Entity.PaymentInfo;
import com.project.transactionalspringboot.Model.FlightBookingAcknowledgement;
import com.project.transactionalspringboot.Model.FlightBookingRequest;
import com.project.transactionalspringboot.Repository.PassengerInfoRepository;
import com.project.transactionalspringboot.Repository.PaymentInfoRepository;
import com.project.transactionalspringboot.Util.PaymentUtils;

@Service
public class FlightBookingService {

	@Autowired
	private PassengerInfoRepository passengerInfoRepository;

	@Autowired
	private PaymentInfoRepository paymentInfoRepository;

	@Transactional
	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest flightBookingRequest) {

		PassengerInfo passengerInfo = flightBookingRequest.getPassengerInfo();
		passengerInfo = passengerInfoRepository.save(passengerInfo);

		PaymentInfo paymentInfo = flightBookingRequest.getPaymentInfo();
		PaymentUtils.validateCredentialLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
		paymentInfo.setPassengerId(passengerInfo.getPassengerId());
		paymentInfo.setAmount(passengerInfo.getFare());
		paymentInfoRepository.save(paymentInfo);
		return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(),
				UUID.randomUUID().toString().split("-")[0], passengerInfo);
	}

}
