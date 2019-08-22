package pl.manicki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.manicki.model.TripAvailable;
import pl.manicki.repository.TripAvailableRepository;

import java.util.List;

@Component
public class TripAvailableService {

    @Autowired
    TripAvailableRepository tripAvailableRepository;

    public List<TripAvailable> getAvailableTrips(Long idAirport) {
        return tripAvailableRepository.findAllByHotel_Airport_IdAirport(idAirport);
    }
}
