package pl.manicki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.manicki.model.Continent;
import pl.manicki.repository.ContinentRepository;

import java.util.List;

@Component
public class ContinentService {
    @Autowired
    private ContinentRepository continentRepository;

    public List<Continent> findAll() {
        return continentRepository.findAll();
    }
}
