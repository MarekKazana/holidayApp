package pl.manicki.model;

import pl.manicki.model.enms.AccommodationOptions;
import pl.manicki.model.enms.Nights;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "trip_available")
public class TripAvailable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTripAvailable;

    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;

    @Column(name = "departure_date")
    private LocalDateTime departureDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "nights")
    private Nights nights;

    @Column(name = "adult_places_available")
    private short adultPlacesAvailable;

    @Column(name = "children_places_available")
    private short childrenPlacesAvailable;

    @Column(name = "promoted")
    private boolean promoted;

    @Column(name = "adult_price")
    private BigDecimal adultPrice;

    @Column(name = "child_price")
    private BigDecimal childPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "accommodation_option")
    private AccommodationOptions accommodationOptions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_airport")
    private Airport airport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    public Long getIdTripAvailable() {
        return idTripAvailable;
    }

    public void setIdTripAvailable(Long idTripAvailable) {
        this.idTripAvailable = idTripAvailable;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public Nights getNights() {
        return nights;
    }

    public void setNights(Nights nights) {
        this.nights = nights;
    }

    public short getAdultPlacesAvailable() {
        return adultPlacesAvailable;
    }

    public void setAdultPlacesAvailable(short adultPlacesAvailable) {
        this.adultPlacesAvailable = adultPlacesAvailable;
    }

    public short getChildrenPlacesAvailable() {
        return childrenPlacesAvailable;
    }

    public void setChildrenPlacesAvailable(short childrenPlacesAvailable) {
        this.childrenPlacesAvailable = childrenPlacesAvailable;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public BigDecimal getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(BigDecimal adultPrice) {
        this.adultPrice = adultPrice;
    }

    public BigDecimal getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(BigDecimal childPrice) {
        this.childPrice = childPrice;
    }

    public AccommodationOptions getAccommodationOptions() {
        return accommodationOptions;
    }

    public void setAccommodationOptions(AccommodationOptions accommodationOptions) {
        this.accommodationOptions = accommodationOptions;
    }
}
