package Personal.Capstone.Controllers;

import Personal.Capstone.Entities.City;
import Personal.Capstone.Entities.User;
import Personal.Capstone.Exceptions.BadRequestException;
import Personal.Capstone.Payloads_DTOs.NewCityDTO;
import Personal.Capstone.Services.CityService;
import Personal.Capstone.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    public CityService cityService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    Page<City> getAllCities(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        return cityService.getAllCities(page, size);
    }

    @GetMapping("/id={id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    City findCityById(@PathVariable long id) {
        return cityService.findCityById(id);
    }

    @GetMapping("/name={name}")
    City findCityByName(@PathVariable String name) {
        return cityService.findCityByName(name);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    public City saveCity(@RequestBody @Validated NewCityDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            try {
                return cityService.saveCity(body);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @PutMapping("/modify/id={id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public City findCityByIdAndUpdate(@PathVariable long id, @RequestBody City body) {
        return cityService.findCityByIdAndUpdate(id, body);
    }

    @DeleteMapping("/id={id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ADMIN')")
    void findCityByIdAndDelete(@PathVariable long id) {
        cityService.findCityByIdAndDelete(id);
    }
}
