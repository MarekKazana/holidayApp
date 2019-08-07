package pl.manicki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CityController {

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        String name = "Mateusz";
        modelAndView.addObject("name", name);
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @RequestMapping(value = "/test2/{name}", method = RequestMethod.GET)
    public ModelAndView loginName(@PathVariable String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", name);
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
