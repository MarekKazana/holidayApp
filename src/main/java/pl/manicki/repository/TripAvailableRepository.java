package pl.manicki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.manicki.model.TripAvailable;

import java.util.List;

@Repository
public interface TripAvailableRepository extends JpaRepository<TripAvailable, Long> {

    List<TripAvailable> findAllByHotel_Airport_IdAirport(Long idAirport);

    List<TripAvailable> findAllByPromotedIsTrueAndHotel_City_Country_IdCountry(Long idCountry);

    List<TripAvailable> findAllByPromotedIsFalseAndHotel_City_Country_IdCountry(Long idCountry);
}
