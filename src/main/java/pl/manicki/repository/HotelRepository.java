package pl.manicki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.manicki.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
