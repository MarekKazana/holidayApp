package pl.manicki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.manicki.model.City;
import pl.manicki.service.CityService;

import java.util.List;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    public List<City> getAllCities() {
        return cityService.findAll();
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public ModelAndView test1(@ModelAttribute("nights") int nights) {
        System.out.println("CityController.test1 | nights = " + nights);
        ModelAndView modelAndView = new ModelAndView();
        String name = "Mateusz";
        modelAndView.addObject("nights", nights);
        modelAndView.addObject("name", name);
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @RequestMapping(value = "/test2/{name}", method = RequestMethod.GET)
    public ModelAndView test2(@PathVariable String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", name);
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
