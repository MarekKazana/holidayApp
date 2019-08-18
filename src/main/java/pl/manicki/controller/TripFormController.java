package pl.manicki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.manicki.model.Airport;
import pl.manicki.model.Continent;
import pl.manicki.model.Country;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TripFormController {

    @Autowired
    private TripController tripController;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView fillBasicForm() {
        List<Continent> continents = tripController.getAllContinents();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("continents", continents);
        modelAndView.addObject("today", LocalDate.now());
        modelAndView.addObject("tripFormController", this);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/setTripDetails", method = RequestMethod.GET)
    public ModelAndView setTripDetails(
            @ModelAttribute("fromCountry") Long idFromCountry,
            @ModelAttribute("destinationCountry") Long idDestinationCountry,
            @ModelAttribute("fromDate") String fromDate,
            @ModelAttribute("toDate") String toDate,
            @ModelAttribute("nights") int nights) {
        ModelAndView modelAndView = new ModelAndView();
        String responseMessage = tripController.isDateCorrect(fromDate, toDate);
        if (responseMessage.equals("datesAreCorrect")) {
            modelAndView.addObject("tripFormController", this);
            modelAndView.setViewName("selectTripDetails");
        } else {
            if (responseMessage.equals("parsingError")) {
                modelAndView.addObject("errorMessage", "Complete the 'date fields' and try again");
            } else {
                modelAndView.addObject("errorMessage", "'From date' have to be before 'To date'. Complete the fields correctly and try again");
            }
            modelAndView.setViewName("confirmations/error");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/findTrip", method = RequestMethod.POST)
    public ModelAndView findTrip(
            @ModelAttribute("destinationCountry") Long idDestinationCountry) {
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
}
