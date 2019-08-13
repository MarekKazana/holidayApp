package pl.manicki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.manicki.model.Continent;
import pl.manicki.service.ContinentService;

import java.util.List;

@Controller
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    public List<Continent> getAllContinents() {
        List<Continent> continents = continentService.findAll();
        return continents;
    }

    private List<Continent> setContinentsPrefix(List<Continent> continents) {
        for(Continent continent : continents) {
            continent.setName("con_" + continent.getName());
        }
        return continents;
    }
}
