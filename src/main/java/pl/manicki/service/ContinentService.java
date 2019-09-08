package pl.manicki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.manicki.model.Continent;
import pl.manicki.repository.ContinentRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContinentService {
    @Autowired
    private ContinentRepository continentRepository;

    public List<Continent> findAll() {
        return continentRepository.findAll().stream()
                .sorted(Comparator.comparing(Continent::getName))
                .collect(Collectors.toList());
    }
}
