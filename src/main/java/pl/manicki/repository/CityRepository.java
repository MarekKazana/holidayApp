package pl.manicki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.manicki.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
