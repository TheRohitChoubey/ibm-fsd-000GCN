package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String pname;
	@OneToOne
	private Reservation reservation;

	@ManyToMany
	@JoinTable(name = "flight_passenger", joinColumns = @JoinColumn(name = "passenger_id"), inverseJoinColumns = @JoinColumn(name = "flight_id"))
	private Set<Flight> flights = new HashSet<>();

	public Passenger() {
    }

	public Passenger(String pname, Reservation reservation) {
		super();
		this.pname = pname;
		this.reservation = reservation;
	}

	public Passenger(String pname, Reservation reservation, Set<Flight> flights) {
		super();
		this.pname = pname;
		this.reservation = reservation;
		this.flights = flights;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", pname=" + pname + ", reservation=" + reservation + ", flights=" + flights
				+ "]";
	}

}
