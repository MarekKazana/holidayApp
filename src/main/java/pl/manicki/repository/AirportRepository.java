package pl.manicki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.manicki.model.Airport;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    List<Airport> findAirportsByCity_Country_IdCountry(Long idCountry);
}
