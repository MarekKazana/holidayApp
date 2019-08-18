package pl.manicki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.manicki.repository.CityRepository;

@Component
public class CityService {
    @Autowired
    private CityRepository cityRepository;

}
