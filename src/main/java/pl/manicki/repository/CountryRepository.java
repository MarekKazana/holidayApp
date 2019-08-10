package pl.manicki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.manicki.model.Country;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    public List<Country> findCountriesByContinentIdContinent(Long continent_idContinent);
}
