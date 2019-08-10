package pl.manicki.model;

import javax.persistence.*;

@Entity
@Table(name = "trip_available")
public class TripAvailable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTripAvailable;

//    private Long
}
