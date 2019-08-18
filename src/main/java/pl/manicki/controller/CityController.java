package pl.manicki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.manicki.service.CityService;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;

}
