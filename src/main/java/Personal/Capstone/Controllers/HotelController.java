package Personal.Capstone.Controllers;

import Personal.Capstone.Entities.Hotel;
import Personal.Capstone.Exceptions.BadRequestException;
import Personal.Capstone.Payloads_DTOs.NewHotelDTO;
import Personal.Capstone.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    public HotelService hotelService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    Page<Hotel> getAllHotels(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        return hotelService.getAllHotels(page, size);
    }

    @GetMapping("/id={id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    Hotel findHotelById(@PathVariable long id) {
        return hotelService.findHotelById(id);
    }

    @GetMapping("/name={name}")
    @PreAuthorize("hasAuthority('ADMIN')")
    Hotel findHotelByName(@PathVariable String name) {
        return hotelService.findHotelByName(name);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Hotel saveHotel(@RequestBody @Validated NewHotelDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            try {
                return hotelService.saveHotel(body);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @PutMapping("/modify/id={id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Hotel findHotelByIdAndUpdate(@PathVariable long id, @RequestBody Hotel body) {
        return hotelService.findHotelByIdAndUpdate(id, body);
    }

    @DeleteMapping("/id={id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ADMIN')")
    void findHotelByIdAndDelete(@PathVariable long id) {
        hotelService.findHotelByIdAndDelete(id);
    }
}
