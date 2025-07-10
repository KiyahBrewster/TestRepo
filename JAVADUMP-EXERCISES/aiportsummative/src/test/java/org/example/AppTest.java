package com.airport.domain.reservation;

import com.airport.domain.model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AirportTerminalTest {

    @Test
    void testAddAndGetReservation() {
        ReservationSystem rs = new ReservationSystem();
        Passenger passenger = new Passenger("Test User", "T123456");
        rs.addReservation("FL123", passenger);

        List<Passenger> passengers = rs.getPassengersForFlight("FL123");

        assertEquals(1, passengers.size());
        assertEquals("Test User", passengers.get(0).getName());
    }

    @Test
    void testFlightCreation() {
        Aircraft aircraft = new CommercialAircraft("Boeing 747", 300, 50000, "TestAir");
        Flight flight = new Flight("TA100", LocalDate.of(2025, 7, 15), new BigDecimal("499.99"), aircraft);

        assertEquals("TA100", flight.getFlightNumber());
        assertEquals("Boeing 747", flight.getAircraft().getModel());
        assertEquals(300, flight.getAircraft().getCapacity());
    }

    @Test
    void testEmptyReservationList() {
        ReservationSystem rs = new ReservationSystem();
        List<Passenger> passengers = rs.getPassengersForFlight("NONEXISTENT");

        assertTrue(passengers.isEmpty());
    }

    @Test
    void testMultiplePassengers() {
        ReservationSystem rs = new ReservationSystem();
        rs.addReservation("FL456", new Passenger("Alice", "P11111"));
        rs.addReservation("FL456", new Passenger("Bob", "P22222"));

        List<Passenger> passengers = rs.getPassengersForFlight("FL456");

        assertEquals(2, passengers.size());
    }

    @Test
    void testAllReservationsMap() {
        ReservationSystem rs = new ReservationSystem();
        rs.addReservation("FL789", new Passenger("Charlie", "P33333"));

        Map<String, List<Passenger>> all = rs.getAllReservations();
        assertTrue(all.containsKey("FL789"));
    }
}
