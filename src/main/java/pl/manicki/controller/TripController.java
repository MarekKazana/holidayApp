package pl.manicki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.manicki.service.TripService;

@Controller
public class TripController {

    @Autowired
    private TripService tripService;

    public String isDateCorrect(String fromDate, String toDate) {
        return tripService.isDateCorrect(fromDate, toDate);
    }
}
