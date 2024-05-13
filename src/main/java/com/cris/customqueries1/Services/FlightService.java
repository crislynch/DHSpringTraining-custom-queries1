package com.cris.customqueries1.Services;

import com.cris.customqueries1.Entities.Flight;
import com.cris.customqueries1.Entities.FlightStatuus;
import com.cris.customqueries1.Repositories.FlightResporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class FlightService {

    @Autowired
    FlightResporitory flightRepository;

    public List<Flight> createFlights(int count) {
        Random random = new Random();
        List<Flight> flights = IntStream.range(0, count)
                .mapToObj(i -> {
                    Flight flight = new Flight();
                    flight.setDescription("Flight " + i);
                    flight.setDeparture(generateAirportCode());
                    flight.setArrival(generateAirportCode());
                    flight.setStatus(FlightStatuus.ONTIME);
                    return flight;
                })
                .collect(Collectors.toList());
        return flightRepository.saveAll(flights);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    private String generateAirportCode() {
        Random random = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return sb.toString();
    }

    public List<Flight> getFlightsByStatus(FlightStatuus status) {
        return flightRepository.findByStatus(status);
    }
}
