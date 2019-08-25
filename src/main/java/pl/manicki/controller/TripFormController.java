package pl.manicki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.manicki.model.Airport;
import pl.manicki.model.Country;
import pl.manicki.model.TripAvailable;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Controller
public class TripFormController {

    @Autowired
    private TripController tripController;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView fillBasicForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("continents", tripController.getAllContinents());
        modelAndView.addObject("today", LocalDate.now());
        modelAndView.addObject("tripFormController", this);
        modelAndView.setViewName("index");
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

    @RequestMapping(value = "/setTripDetails", method = RequestMethod.GET)
    public ModelAndView setTripDetails(
            @ModelAttribute("fromCountry") Long idFromCountry,
            @ModelAttribute("destinationCountry") Long idDestinationCountry,
            @ModelAttribute("fromDate") String fromDate,
            @ModelAttribute("toDate") String toDate,
            @ModelAttribute("nights") int nights,
            @ModelAttribute("idTrip") Long idTrip) {
        ModelAndView modelAndView = new ModelAndView();
        checkCorrectnessOdTheDate(fromDate, toDate, modelAndView);
        return modelAndView;
    }

    @RequestMapping(value = "/findTrip", method = RequestMethod.POST)
    public ModelAndView findTrip(
            @ModelAttribute("destinationAirport") Long idDestinationAirport) {
        ModelAndView modelAndView = new ModelAndView();
        List<TripAvailable> allTrips = tripController.getAvailableTrips(idDestinationAirport);
        modelAndView.addObject("promotedTripsFound", tripController.getPromotedTrips(allTrips));
        modelAndView.addObject("standardTripsFound", tripController.getStandardTrips(allTrips));
        modelAndView.setViewName("tripsFound");
        return modelAndView;
    }

    @RequestMapping(value = "/selectedTripFromMainPage", method = RequestMethod.POST)
    public ModelAndView selectedTripFromMainPage(@ModelAttribute("idTrip") Long idTrip) {
        System.out.println("TripFormController.selectedTripFromMainPage | idTrip = " + idTrip);
        //TODO Add to model and view object of selected trip and show it on setTripDetails with locked the fields of airports.
        return fillBasicForm();
    }

    @RequestMapping(value = "/selectedTrip", method = RequestMethod.POST)
    public ModelAndView selectedTrip(@ModelAttribute("idTrip") Long idTrip) {
        System.out.println("TripFormController.selectedTrip | idTrip = " + idTrip);
        return fillBasicForm();
    }

    public List<Country> getCountryByContinent(Long idContinent) {
        return tripController.getCountryByContinent(idContinent);
    }

    public Country getCountry(Long idCountry) {
        return tripController.getCountry(idCountry);
    }

    public List<Airport> getAirportsFromCountry(Long idCountry) {
        return tripController.getAirportsFromCountry(idCountry);
    }

    public List<TripAvailable> getAllPromotedTripsFromCountry(Long idCountry) {
        return tripController.getAllPromotedTripsFromCountry(idCountry);
    }

    private void checkCorrectnessOdTheDate(
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
