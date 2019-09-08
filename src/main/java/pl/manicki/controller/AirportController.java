package pl.manicki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.manicki.model.Airport;
import pl.manicki.service.AirportService;

import java.util.List;

@Controller
public class AirportController {

    @Autowired
    private AirportService airportService;

    public List<Airport> getAirportsFromCountry(Long idCountry) {
        return airportService.getAirportsFromCountry(idCountry);
    }

    public Airport getAirport(Long idAirport) {
        return airportService.getAirport(idAirport);
    }
}
