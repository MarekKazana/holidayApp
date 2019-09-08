package pl.manicki.generators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.manicki.controller.AirportController;
import pl.manicki.controller.HotelController;
import pl.manicki.controller.TripAvailableController;
import pl.manicki.model.Airport;
import pl.manicki.model.Hotel;
import pl.manicki.model.TripAvailable;
import pl.manicki.model.enms.AccommodationOptions;
import pl.manicki.model.enms.Nights;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Controller
public class TripGenerator {

    @Autowired
    private TripAvailableController tripAvailableController;

    @Autowired
    private AirportController airportController;

    @Autowired
    private HotelController hotelController;

    public void generateTrip() {
        DateGenerator dateGenerator = new DateGenerator();
        PriceGenerator priceGenerator = new PriceGenerator();

        Nights nights = Nights.values()[new Random().nextInt(Nights.values().length)];
        LocalDateTime arrivalDate = dateGenerator.generateArrivalDate();
        LocalDateTime departureDate = dateGenerator.generateDepartureDate(arrivalDate, nights.getValue());
        short adultPlacesAvailable = (short) (20 + new Random().nextInt(80));
        short childrenPlacesAvailable = (short) (adultPlacesAvailable + new Random().nextInt(40));
        boolean promoted = new Random().nextBoolean();
        BigDecimal adultPrice = priceGenerator.generateAdultPrice();
        BigDecimal childrenPrice = priceGenerator.generateChildrenPrice(adultPrice);
        AccommodationOptions accommodationOption = AccommodationOptions.values()[new Random().nextInt(AccommodationOptions.values().length)];
        Airport airport = airportController.getAirport((long) (new Random().nextInt(airportController.getAirportsFromCountry(1L).size() - 1) + 1));
        Hotel hotel = hotelController.getHotel((long) (new Random().nextInt(hotelController.getAll().size() - 1) + 1));

        TripAvailable tripAvailable = new TripAvailable(
                arrivalDate,
                departureDate,
                nights,
                adultPlacesAvailable,
                childrenPlacesAvailable,
                promoted,
                adultPrice,
                childrenPrice,
                accommodationOption,
                airport,
                hotel);

        System.out.println("Arrival date = " + arrivalDate + ", departure date = " + departureDate);
        System.out.println(nights + " " + nights.getValue());
        System.out.println("Adult price = " + adultPrice + ", children price = " + childrenPrice);
        System.out.println("Adult places available = " + adultPlacesAvailable + ", children places available = " + childrenPlacesAvailable);
        System.out.println("promoted = " + promoted + ", accomodation option = " + accommodationOption);
        System.out.println("AirportId = " + airport.getIdAirport() + ", Hotel = " + hotel.getIdHotel());

        tripAvailableController.save(tripAvailable);
    }
}

class DateGenerator {
    public LocalDateTime generateArrivalDate() {
        return LocalDateTime.parse(
                LocalDate.now().minusDays(30).plusDays(new Random().nextInt(90))
                        + " "
                        + LocalTime.of(new Random().nextInt(24), Minutes.values()[new Random().nextInt(Minutes.values().length)].getValue()),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public LocalDateTime generateDepartureDate(LocalDateTime arrivalDate, int nights) {
        return LocalDateTime.parse(
                arrivalDate.toLocalDate()
                        .plusDays(nights + 1).toString()
                        + " "
                        + LocalTime.of(new Random().nextInt(24), Minutes.values()[new Random().nextInt(Minutes.values().length)].getValue()),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}

class PriceGenerator {
    public BigDecimal generateAdultPrice() {
        return new BigDecimal(49.99 + new Random().nextDouble() * 100)
                .setScale(2, BigDecimal.ROUND_FLOOR);
    }

    public BigDecimal generateChildrenPrice(BigDecimal adultPrice) {
        return new BigDecimal(
                String.valueOf(
                        adultPrice.multiply(
                                new BigDecimal(
                                        90 - new Random().nextInt(25)
                                ).divide(new BigDecimal(100)
                                )
                        )
                )
        ).setScale(2, BigDecimal.ROUND_FLOOR);
    }
}

enum Minutes {
    min00(00),
    min15(15),
    min30(30),
    min45(45);

    private int value;

    Minutes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}