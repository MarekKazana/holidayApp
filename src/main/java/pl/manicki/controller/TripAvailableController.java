package pl.manicki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.manicki.model.TripAvailable;
import pl.manicki.service.TripAvailableService;

import java.util.List;

@Controller
public class TripAvailableController {
    
    @Autowired
    private TripAvailableService tripAvailableService;

    public List<TripAvailable> getAvailableTrips(Long idAirport) {
        return tripAvailableService.getAvailableTrips(idAirport);
    }

    public List<TripAvailable> getAllPromotedTripsFromCountry(Long idCountry) {
        return tripAvailableService.getAllPromotedTripsFromCountry(idCountry);
    }
}
