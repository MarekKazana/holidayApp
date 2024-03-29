package pl.manicki.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private Long idHotel;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private float rating;

    @Column(name = "address")
    private String address;

    @Column(name = "img_url", length = 500)
    private String imgUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_city")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_airport")
    private Airport airport;

    @OneToMany(mappedBy = "hotel")
    private List<TripAvailable> tripAvailableList;

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public List<TripAvailable> getTripAvailableList() {
        return tripAvailableList;
    }

    public void setTripAvailableList(List<TripAvailable> tripAvailableList) {
        this.tripAvailableList = tripAvailableList;
    }
}
