package Personal.Capstone.Repositories;

import Personal.Capstone.Entities.City;
import Personal.Capstone.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByName(String name);
}
