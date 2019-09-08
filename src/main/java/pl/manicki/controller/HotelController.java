package pl.manicki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.manicki.model.Hotel;
import pl.manicki.service.HotelService;

import java.util.List;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    public List<Hotel> getAll() {
        return hotelService.getAll();
    }

    public Hotel getHotel(Long idHotel) {
        return hotelService.getHotel(idHotel);
    }
}
