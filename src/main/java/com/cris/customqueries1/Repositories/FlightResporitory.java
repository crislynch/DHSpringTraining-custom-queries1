package com.cris.customqueries1.Repositories;

import com.cris.customqueries1.Entities.Flight;
import com.cris.customqueries1.Entities.FlightStatuus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightResporitory extends JpaRepository<Flight, Long> {
    List<Flight> findByStatus(FlightStatuus flightStatus);
}
