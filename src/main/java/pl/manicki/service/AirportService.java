package pl.manicki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.manicki.model.Airport;
import pl.manicki.repository.AirportRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAirportsFromCountry(Long idCountry) {
        return airportRepository.findAirportsByCity_Country_IdCountry(idCountry).stream()
                .sorted(Comparator.comparing(Airport::getName))
                .collect(Collectors.toList());
    }

    public Airport getAirport(Long idAirport) {
        return airportRepository.getOne(idAirport);
    }
}
