package pl.manicki.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "continent")
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_continent")
    private Long idContinent;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "continent")
    private List<Country> countries;

    public Long getIdContinent() {
        return idContinent;
    }

    public void setIdContinent(Long idContinent) {
        this.idContinent = idContinent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
