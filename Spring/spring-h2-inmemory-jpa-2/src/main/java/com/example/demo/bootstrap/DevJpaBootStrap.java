package com.example.demo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


import com.example.demo.model.Reservation;
import com.example.demo.repository.FlightRepository;
import com.example.demo.repository.PassengerRepository;
import com.example.demo.repository.ReservationRepository;

@Component
public class DevJpaBootStrap {

	private PassengerRepository passengerRepository;
	private ReservationRepository reservationRepository;
	private FlightRepository flightRepository;

	public DevJpaBootStrap(PassengerRepository passengerRepository, ReservationRepository reservationRepository,
			FlightRepository flightRepository) {
		super();
		this.passengerRepository = passengerRepository;
		this.reservationRepository = reservationRepository;
		this.flightRepository = flightRepository;
	}

}