package Personal.Capstone.Repositories;

import Personal.Capstone.Entities.City;
import Personal.Capstone.Entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findByName(String name);
}
