package pl.manicki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.manicki.model.TripAvailable;

import java.util.List;

public interface TripAvailableRepository extends JpaRepository<TripAvailable, Long> {
    List<TripAvailable> findAllByHotel_Airport_IdAirport(Long idAirport);

    List<TripAvailable> findAllByPromotedIsTrueAndHotel_City_Country_IdCountry(Long idCountry);
}
