package pl.manicki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.manicki.model.Continent;
import pl.manicki.service.ContinentService;

import java.util.List;

@Controller
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAllContinents() {
        ModelAndView modelAndView = new ModelAndView();
        List<Continent> continents = continentService.findAll();
        modelAndView.addObject("continents", setContinentsPrefix(continents));
        modelAndView.setViewName("index");
        return modelAndView;
    }

    private List<Continent> setContinentsPrefix(List<Continent> continents) {
        for(Continent continent : continents) {
            continent.setName("con_" + continent.getName());
        }
        return continents;
    }
}
