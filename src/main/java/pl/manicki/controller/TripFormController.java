package pl.manicki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.manicki.model.City;
import pl.manicki.model.Continent;
import pl.manicki.model.Country;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TripFormController {

    @Autowired
    private ContinentController continentController;

    @Autowired
    private CountryController countryController;

    @RequestMapping(name = "/", method = RequestMethod.GET)
    public ModelAndView fillBasicForm() {
        List<Continent> continents = continentController.getAllContinents();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("continents", continents);
        modelAndView.addObject("trip", this);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    public List<Country> getCountryByContinent(Long idContinent) {
        return countryController.getCountryByContinent(idContinent);
    }
}
