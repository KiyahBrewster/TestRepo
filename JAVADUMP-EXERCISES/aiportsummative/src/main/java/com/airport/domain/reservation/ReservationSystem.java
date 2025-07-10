package com.airport.domain.reservation;

import com.airport.domain.model.Passenger;
import java.util.*;

public class ReservationSystem {
    private Map<String, List<Passenger>> reservations = new HashMap<>();

    public void addReservation(String flightNumber, Passenger passenger) {
        reservations.computeIfAbsent(flightNumber, k -> new ArrayList<>()).add(passenger);
    }

    public List<Passenger> getPassengersForFlight(String flightNumber) {
        return reservations.getOrDefault(flightNumber, new ArrayList<>());
    }

    public Map<String, List<Passenger>> getAllReservations() {
        return reservations;
    }
}