package org.acumen.training.codes.itemc.test;

import java.util.List;
import java.util.Map;

import org.acumen.training.codes.itemc.Flights;
import org.acumen.training.codes.itemc.Flights.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFlights {

	private Flights flights;

	@BeforeEach
	public void setUp() {
		flights = new Flights();
	}

	@Test
	public void testListPassengers() {Flights flights = new Flights();
	Map<Integer, List<Passenger>> passengers = flights.listPassengers();
	flights.printPassengerDetails(passengers);

	}
}
