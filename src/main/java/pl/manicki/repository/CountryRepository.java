package pl.manicki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.manicki.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
