package com.project.transactionalspringboot.Entity;

import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "PASSENGER_INFO")
public class PassengerInfo {

	@Id
	@GeneratedValue
	@Column(name = "p_id")
	private Long passengerId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "travelDate")
	private Date travelDate;
	
	@Column(name = "pickupTime")
	private String pickupTime;
	
	@Column(name = "arrivalTime")
	private String arrivalTime;
	
	@Column(name = "fare")
	private double fare;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "startDate")
	private TimeZone startDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "endDate")
	private TimeZone endDate;
}
