package pl.manicki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manicki.model.Hotel;
import pl.manicki.repository.HotelRepository;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public Hotel getHotel(Long idHotel) {
        return hotelRepository.getOne(idHotel);
    }

    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }
}
