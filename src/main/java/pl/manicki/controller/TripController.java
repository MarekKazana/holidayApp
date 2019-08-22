package pl.manicki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.manicki.model.Airport;
import pl.manicki.model.Continent;
import pl.manicki.model.Country;
import pl.manicki.model.TripAvailable;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TripController {

    @Autowired
    private ContinentController continentController;

    @Autowired
    private CountryController countryController;

    @Autowired
    private CityController cityController;

    @Autowired
    private AirportController airportController;

    @Autowired
    private TripAvailableController tripAvailableController;


    public List<Continent> getAllContinents() {
        return continentController.getAllContinents();
    }

    public List<Country> getCountryByContinent(Long idContinent) {
        return countryController.getCountryByContinent(idContinent);
    }

    public Country getCountry(Long idCountry) {
        return countryController.getCountry(idCountry);
    }

    public List<Airport> getAirportsFromCountry(Long idCountry) {
        return airportController.getAirportsFromCountry(idCountry);
    }

    public List<TripAvailable> getAvailableTrips(Long idAirport) {
        return tripAvailableController.getAvailableTrips(idAirport);
    }

    public String isDateCorrect(String fromDate, String toDate) {
        try {
            LocalDate fromDateParsed = LocalDate.parse(fromDate);
            LocalDate toDateParsed = LocalDate.parse(toDate);
            if (!fromDateParsed.isBefore(toDateParsed)) {
                return "datesError";
            } else if (fromDateParsed.isBefore(LocalDate.now())) {
                return "fromDatePast";
            }
        } catch (Exception e) {
            return "parsingError";
        }
        return "datesAreCorrect";
    }
}
