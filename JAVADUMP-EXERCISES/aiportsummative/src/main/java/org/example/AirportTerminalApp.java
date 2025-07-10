package org.example;

import com.airport.domain.model.*;;
import com.airport.domain.reservation.ReservationSystem;
import com.airport.data.CSVUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class AirportTerminalApp {
    public static void main(String[] args) {
        ReservationSystem rs = new ReservationSystem();
        Map<String, Flight> flights = new HashMap<>();

        Aircraft commercial = new CommercialAircraft("Boeing 737", 180, 26000, "American Airlines");
        Aircraft privateJet = new PrivateJet("Gulfstream G650", 10, 12000, true, 900);

        Flight f1 = new Flight("AA101", LocalDate.of(2024, 5, 10), new BigDecimal("299.99"), commercial);
        Flight f2 = new Flight("PJ001", LocalDate.of(2024, 7, 20), new BigDecimal("5000.00"), privateJet);

        flights.put(f1.getFlightNumber(), f1);
        flights.put(f2.getFlightNumber(), f2);

        rs.addReservation("AA101", new Passenger("Alice Smith", "P12345"));

        try {
            CSVUtil.saveReservationsToCSV("reservations.csv", rs.getAllReservations(), flights);
            Map<String, Flight> loadedFlights = CSVUtil.loadReservationsFromCSV("reservations.csv", rs);
            for (String flightNumber : rs.getAllReservations().keySet()) {
                System.out.println("Passengers on flight " + flightNumber + ":");
                for (Passenger p : rs.getPassengersForFlight(flightNumber)) {
                    System.out.println("- " + p.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
