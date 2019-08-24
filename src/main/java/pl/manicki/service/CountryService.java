package pl.manicki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.manicki.model.Country;
import pl.manicki.repository.CountryRepository;

import java.util.List;

@Component
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountryByContinent(Long idContinent) {
        return countryRepository.findCountriesByContinentIdContinent(idContinent);
    }

    public Country getCountry(Long idCountry) {
        return countryRepository.findById(idCountry).isPresent() ? countryRepository.findById(idCountry).get() : null;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
