package Personal.Capstone.Services;

import Personal.Capstone.Entities.City;
import Personal.Capstone.Entities.Role;
import Personal.Capstone.Entities.User;
import Personal.Capstone.Exceptions.BadRequestException;
import Personal.Capstone.Exceptions.NotFoundException;
import Personal.Capstone.Payloads_DTOs.NewCityDTO;
import Personal.Capstone.Payloads_DTOs.NewUserDTO;
import Personal.Capstone.Repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepo;

    public City saveCity(NewCityDTO cityDTO) throws IOException {
        cityRepo.findByName(cityDTO.name()).ifPresent(city -> {
            throw new BadRequestException("city with name " + city.getName() + " is already in the database");
        });
        City newCity = new City();
        newCity.setName(cityDTO.name());
        newCity.setProvince(cityDTO.province());
        newCity.setState(cityDTO.state());
        newCity.setPopulation(cityDTO.population());
        return cityRepo.save(newCity);
    }

    public City findCityById(long id) throws NotFoundException {
        return cityRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public City findCityByName(String name) throws NotFoundException {
        return cityRepo.findByName(name).orElseThrow(() -> new RuntimeException("name not found"));
    }

    public Page<City> getAllCities(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return cityRepo.findAll(pageable);
    }

    public City findCityByIdAndUpdate(long id, City body) throws NotFoundException {
        City target = this.findCityById(id);
        target.setName(body.getName());
        target.setProvince(body.getProvince());
        target.setState(body.getState());
        target.setPopulation(body.getPopulation());
        return cityRepo.save(target);
    }


    public void findCityByIdAndDelete(long id) throws NotFoundException {
        City foundCity = this.findCityById(id);
        cityRepo.delete(foundCity);
    }


}
