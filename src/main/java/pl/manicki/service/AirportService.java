package pl.manicki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.manicki.model.Airport;
import pl.manicki.repository.AirportRepository;

import java.util.List;

@Component
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAirportsFromCountry(Long idCountry) {
        return airportRepository.findAirportsByCity_Country_IdCountry(idCountry);
    }
}
