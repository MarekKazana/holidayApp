package pl.manicki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.manicki.model.Country;
import pl.manicki.service.CountryService;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    public List<Country> getCountryByContinent(Long idContinent) {
        return countryService.getCountryByContinent(idContinent);
    }

    public Country getCountry(Long idCountry) {
        return countryService.getCountry(idCountry);
    }
}
