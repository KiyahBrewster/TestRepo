package com.airport.data;

import com.airport.domain.model.*;
import com.airport.domain.reservation.ReservationSystem;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

public class CSVUtil {
    public static void saveReservationsToCSV(String filename, Map<String, List<Passenger>> reservations, Map<String, Flight> flights) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            for (String flightNumber : reservations.keySet()) {
                Flight flight = flights.get(flightNumber);
                for (Passenger p : reservations.get(flightNumber)) {
                    String type = flight.getAircraft() instanceof CommercialAircraft ? "Commercial" : "PrivateJet";
                    writer.write(String.join(",",
                            flight.getFlightNumber(),
                            flight.getDepartureDate().toString(),
                            flight.getTicketPrice().toString(),
                            p.getName(),
                            p.getPassportNumber(),
                            flight.getAircraft().getModel(),
                            type));
                    writer.newLine();
                }
            }
        }
    }

    public static Map<String, Flight> loadReservationsFromCSV(String filename, ReservationSystem rs) throws IOException {
        Map<String, Flight> flights = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String flightNum = parts[0];
                LocalDate date = LocalDate.parse(parts[1]);
                BigDecimal price = new BigDecimal(parts[2]);
                String passengerName = parts[3];
                String passport = parts[4];
                String model = parts[5];
                String type = parts[6];

                Aircraft aircraft = type.equals("Commercial") ? new CommercialAircraft(model, 0, 0, "") : new PrivateJet(model, 0, 0, false, 0);
                Flight flight = new Flight(flightNum, date, price, aircraft);
                flights.putIfAbsent(flightNum, flight);
                if (!passengerName.equals("None")) {
                    rs.addReservation(flightNum, new Passenger(passengerName, passport));
                }
            }
        }
        return flights;
    }
}