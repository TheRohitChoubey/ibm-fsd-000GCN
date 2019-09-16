package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String flightName;

	@ManyToMany(mappedBy = "flights")
	private Set<Passenger> passengers = new HashSet<>();

	public Flight() {

	}

	public Flight(String flightName) {
		super();
		this.flightName = flightName;
	}

	public Flight(String flightName, Set<Passenger> passengers) {
		super();
		this.flightName = flightName;
		this.passengers = passengers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightName=" + flightName + ", passengers=" + passengers + "]";
	}
	
	
}
