package pl.manicki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.manicki.model.TripAvailable;
import pl.manicki.repository.TripAvailableRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TripAvailableService {

    @Autowired
    private TripAvailableRepository tripAvailableRepository;

    public List<TripAvailable> getAvailableTrips(Long idAirport) {
        return tripAvailableRepository.findAllByHotel_Airport_IdAirport(idAirport);
    }

    public List<TripAvailable> getAllPromotedTripsFromCountry(Long idCountry) {
        return tripAvailableRepository.findAllByPromotedIsTrueAndHotel_City_Country_IdCountry(idCountry).stream()
                .filter(trip -> trip.getArrivalDate().isAfter(LocalDateTime.now()))
                .collect(Collectors.toList());
    }
}
