package pl.manicki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.manicki.model.City;
import pl.manicki.model.Continent;
import pl.manicki.model.Country;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TripFormController {

    @Autowired
    private ContinentController continentController;

    @Autowired
    private CountryController countryController;

    @Autowired
    private CityController cityController;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView fillBasicForm() {
        List<Continent> continents = continentController.getAllContinents();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("continents", continents);
        modelAndView.addObject("basicCountry", getCountryByContinent(1l).get(1));
        modelAndView.addObject("tripFormController", this);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/setTripDetails", method = RequestMethod.GET)
    public ModelAndView setTripDetails(
            @ModelAttribute("fromCountry") Long idFromCounytry,
            @ModelAttribute("destinationCountry") Long idDestinationCountry,
            @ModelAttribute("fromDate") String fromDate,
            @ModelAttribute("toDate") String toDate,
            @ModelAttribute("nights") int nights) {
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("fromCountry", idFromCounytry);
//        modelAndView.addObject("destinationCountry", idDestinationCountry);
//        modelAndView.addObject("fromDate", LocalDate.parse(fromDate));
//        modelAndView.addObject("toDate", LocalDate.parse(toDate));
//        modelAndView.addObject("nights", nights);
        modelAndView.addObject("tripFormController", this);
        modelAndView.setViewName("selectTripDetails");
        return modelAndView;
    }

    public List<Country> getCountryByContinent(Long idContinent) {
        return countryController.getCountryByContinent(idContinent);
    }

    public List<City> getCitiesFromCountry(Long idCountry) {
        return cityController.getCitiesFromCountry(idCountry);
    }

    public Country getCountry(Long idCountry) {
        return countryController.getCountry(idCountry);
    }
}
