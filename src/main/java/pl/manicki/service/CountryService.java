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

    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
