package pl.manicki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.manicki.model.City;
import pl.manicki.repository.CityRepository;

import java.util.List;

@Component
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
