package pl.manicki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.manicki.generators.TripGenerator;
import pl.manicki.model.Airport;
import pl.manicki.model.Country;
import pl.manicki.model.TripAvailable;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@RestController
public class TripFormController {

    @Autowired
    private TripController tripController;

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

    @Autowired
    private TripGenerator tripGenerator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView fillBasicForm() {
        ModelAndView modelAndView = new ModelAndView();
        List<TripAvailable> allTrips = tripAvailableController.getAllTrips();
        modelAndView
                .addObject("continents", continentController.getAllContinents())
                .addObject("today", LocalDate.now())
                .addObject("tripFormController", this)
                .addObject("promotedTripsCounter", tripAvailableController.getPromotedTrips(allTrips).size())
                .addObject("standardTripsLastMinuteCounter", tripAvailableController.countStandardLastMinuteTrips(allTrips))
        ;
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/setTripDetails", method = RequestMethod.GET)
    public ModelAndView setTripDetails(
            @ModelAttribute("idFromCountry") Long idFromCountry,
            @ModelAttribute("idDestinationCountry") Long idDestinationCountry,
            @ModelAttribute("fromDate") String fromDate,
            @ModelAttribute("toDate") String toDate,
            @ModelAttribute("nights") int nights,
            @ModelAttribute("idTrip") Long idTrip) {
        ModelAndView modelAndView = new ModelAndView();
        checkCorrectnessOfTheDate(fromDate, toDate, modelAndView);

        if (idTrip != -1) {
            modelAndView
                    .addObject("trip", tripAvailableController.getTrip(idTrip))
                    .addObject("idFromCountry", idFromCountry)
                    .addObject("idDestinationCountry", idDestinationCountry)
            ;
        }
        return modelAndView;
    }

    @RequestMapping(value = "/selectedTripFromMainPage", method = RequestMethod.POST)
    public ModelAndView selectedTripFromMainPage(
            @ModelAttribute("idTrip") Long idTrip,
            @ModelAttribute("source") String source
    ) {
        TripAvailable trip = tripAvailableController.getTrip(idTrip);

        return setTripDetails(
                trip.getAirport().getCity().getCountry().getIdCountry(),
                trip.getHotel().getCity().getCountry().getIdCountry(),
                trip.getArrivalDate().toLocalDate().toString(),
                trip.getDepartureDate().toLocalDate().toString(),
                trip.getNights().getValue(),
                idTrip);
    }

    @RequestMapping(value = "/selectedTrip", method = RequestMethod.POST)
    public ModelAndView selectedTrip(
            @ModelAttribute("idTrip") Long idTrip,
            @ModelAttribute("source") String source
    ) {
        System.out.println("TripFormController.selectedTrip | source = " + source);

        if (source.contains("mainPage")) {
            return selectedTripFromMainPage(idTrip, source);
        } else {
            System.out.println("TripFormController.selectedTrip | idTrip = " + idTrip);
            return fillBasicForm();
        }
    }

    @RequestMapping(value = "/findTrip", method = RequestMethod.POST)
    public ModelAndView findTrip(
            @ModelAttribute("fromAirportId") Long fromAirportId,
            @ModelAttribute("destinationAirportId") Long destinationAirportId) {
        ModelAndView modelAndView = new ModelAndView();
        if (fromAirportId == destinationAirportId) {
            modelAndView.addObject("errorMessage", "Destination airport can not be the same as departure.<br>Fill it correctly and try again.");
            modelAndView.setViewName("confirmations/error");
            return modelAndView;
        }
        List<TripAvailable> allTrips = tripAvailableController.getAvailableTrips(destinationAirportId);
        modelAndView.addObject("promotedTripsFound", tripAvailableController.getPromotedTrips(allTrips));
        modelAndView.addObject("standardTripsFound", tripAvailableController.getStandardTrips(allTrips));
        modelAndView.setViewName("tripsFound");
        return modelAndView;
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public ModelAndView signIn(HttpServletRequest request) {
        request.getSession().setAttribute("user", "admin");
        return fillBasicForm();
    }

    @RequestMapping(value = "/signOut", method = RequestMethod.GET)
    public ModelAndView signOut(HttpServletRequest request) {
        request.getSession().setAttribute("user", "");
        return fillBasicForm();
    }

    @RequestMapping(value = "/genTrip", method = RequestMethod.GET)
    public ModelAndView getTrip() {
        tripGenerator.generateTrip();
        return fillBasicForm();
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

    public List<TripAvailable> getAllPromotedTripsFromCountry(Long idCountry) {
        return tripAvailableController.getAllPromotedTripsFromCountry(idCountry);
    }

    public List<TripAvailable> getAllStandardTripsLastMinuteFromCountry(Long idCountry) {
        return tripAvailableController.getAllStandardTripsLastMinuteFromCountry(idCountry);
    }

    private void checkCorrectnessOfTheDate(
            @ModelAttribute("fromDate") String fromDate,
            @ModelAttribute("toDate") String toDate,
            ModelAndView modelAndView) {

        String responseMessage = tripController.isDateCorrect(fromDate, toDate);
        if (responseMessage.equals("datesAreCorrect")) {
            modelAndView.addObject("tripFormController", this);
            modelAndView.setViewName("selectTripDetails");
        } else {
            if (responseMessage.equals("parsingError")) {
                modelAndView.addObject("errorMessage", "Complete all of the 'date fields' and try again.");
            } else if (responseMessage.equals("fromDatePast")) {
                modelAndView.addObject("errorMessage", "You can't find trip from past. Fill fields correctly and try again.");
            } else {
                modelAndView.addObject("errorMessage", "'From date' have to be before 'To date'. Complete the fields correctly and try again.");
            }
            modelAndView.setViewName("confirmations/error");
        }
    }
}
