package pl.manicki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.manicki.model.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByCountry_IdCountry(Long id);
}
