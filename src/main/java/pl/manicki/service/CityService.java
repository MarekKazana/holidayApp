package pl.manicki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.manicki.repository.CityRepository;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

}
