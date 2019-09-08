package pl.manicki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.manicki.model.Country;
import pl.manicki.repository.CountryRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountryByContinent(Long idContinent) {
        return countryRepository.findCountriesByContinentIdContinent(idContinent).stream()
                .sorted(Comparator.comparing(Country::getName))
                .collect(Collectors.toList());
    }

    public Country getCountry(Long idCountry) {
        return countryRepository.findById(idCountry).get();
    }
}
