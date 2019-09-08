package pl.manicki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manicki.model.TripAvailable;
import pl.manicki.repository.TripAvailableRepository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripAvailableService {

    @Autowired
    private TripAvailableRepository tripAvailableRepository;

    public List<TripAvailable> getAllAvailableTrips() {
        return tripAvailableRepository.findAll().stream()
                .filter(trip -> trip.getArrivalDate().isAfter(LocalDateTime.now()))
                .sorted(Comparator.comparing(TripAvailable::getArrivalDate))
                .collect(Collectors.toList());
    }

    public List<TripAvailable> getAllPromotedTripsFromCountry(Long idCountry) {
        return tripAvailableRepository.findAllByPromotedIsTrueAndHotel_City_Country_IdCountry(idCountry).stream()
                .filter(trip -> trip.getArrivalDate().isAfter(LocalDateTime.now()))
                .sorted(Comparator.comparing(TripAvailable::getArrivalDate))
                .collect(Collectors.toList());
    }

    public List<TripAvailable> getAllPromotedTrips(List<TripAvailable> allTrips) {
        return allTrips.stream()
                .filter(TripAvailable::isPromoted)
                .filter(trip -> trip.getArrivalDate().isAfter(LocalDateTime.now()))
                .sorted(Comparator.comparing(TripAvailable::getArrivalDate))
                .collect(Collectors.toList());
    }

    public List<TripAvailable> getAllStandardTripsLastMinuteFromCountry(Long idCountry) {
        return tripAvailableRepository.findAllByPromotedIsFalseAndHotel_City_Country_IdCountry(idCountry).stream()
                .filter(trip -> trip.getArrivalDate().isAfter(LocalDateTime.now()))
                .filter(trip -> trip.getArrivalDate().isBefore(LocalDateTime.now().plusDays(7)))
                .sorted(Comparator.comparing(TripAvailable::getArrivalDate))
                .collect(Collectors.toList());
    }

    public List<TripAvailable> getAllStandardTrips(List<TripAvailable> allTrips) {
        return allTrips.stream()
                .filter(trip -> !trip.isPromoted())
                .filter(trip -> trip.getArrivalDate().isAfter(LocalDateTime.now()))
                .sorted(Comparator.comparing(TripAvailable::getArrivalDate))
                .collect(Collectors.toList());
    }

    public List<TripAvailable> getAvailableTripsFromRegion(Long idAirport) {
        return tripAvailableRepository.findAllByHotel_Airport_IdAirport(idAirport).stream()
                .filter(trip -> trip.getArrivalDate().isAfter(LocalDateTime.now()))
                .sorted(Comparator.comparing(TripAvailable::getArrivalDate))
                .collect(Collectors.toList());
    }

    public TripAvailable getTrip(Long idTrip) {
        return tripAvailableRepository.findById(idTrip).get();
    }

    public int countStandardLastMinuteTrips(List<TripAvailable> allTrips) {
        return getAllStandardTrips(allTrips.stream()
                .filter(trip -> trip.getArrivalDate().isBefore(LocalDateTime.now().plusDays(7)))
                .collect(Collectors.toList()))
                .size();
    }

    public void save(TripAvailable trip) {
        tripAvailableRepository.save(trip);
    }
}
