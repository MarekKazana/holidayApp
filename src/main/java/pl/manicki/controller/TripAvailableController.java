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
        return tripAvailableService.getAvailableTripsFromRegion(idAirport);
    }

    public List<TripAvailable> getAllPromotedTripsFromCountry(Long idCountry) {
        return tripAvailableService.getAllPromotedTripsFromCountry(idCountry);
    }

    public TripAvailable getTrip(Long idTrip) {
        return tripAvailableService.getTrip(idTrip);
    }

    public List<TripAvailable> getAllStandardTripsLastMinuteFromCountry(Long idCountry) {
        return tripAvailableService.getAllStandardTripsLastMinuteFromCountry(idCountry);
    }

    public List<TripAvailable> getAllTrips() {
        return tripAvailableService.getAllAvailableTrips();
    }

    public void save(TripAvailable trip) {
        tripAvailableService.save(trip);
    }

    public List<TripAvailable> getPromotedTrips(List<TripAvailable> allTrips) {
        return tripAvailableService.getAllPromotedTrips(allTrips);
    }

    public List<TripAvailable> getStandardTrips(List<TripAvailable> allTrips) {
        return tripAvailableService.getAllStandardTrips(allTrips);
    }

    public int countStandardLastMinuteTrips(List<TripAvailable> allTrips) {
        return tripAvailableService.countStandardLastMinuteTrips(allTrips);
    }
}
