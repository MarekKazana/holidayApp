package pl.manicki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.manicki.model.Continent;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long> {

}
