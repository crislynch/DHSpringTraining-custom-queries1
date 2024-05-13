package com.cris.customqueries1.Controllers;

import com.cris.customqueries1.Entities.Flight;
import com.cris.customqueries1.Entities.FlightStatuus;
import com.cris.customqueries1.Repositories.FlightResporitory;
import com.cris.customqueries1.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping("/create-flights")
    public List<Flight> createFlights() {
        return flightService.createFlights(50);
    }

    @GetMapping("/all-flights")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/by-status")
    public List<Flight> getFlightsByStatus(@RequestParam("status") FlightStatuus status) {
        return flightService.getFlightsByStatus(status);
    }
}
