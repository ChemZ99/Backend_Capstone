package Personal.Capstone.Controllers;

import Personal.Capstone.Entities.Hotel;
import Personal.Capstone.Entities.Reservation;
import Personal.Capstone.Exceptions.BadRequestException;
import Personal.Capstone.Payloads_DTOs.NewHotelDTO;
import Personal.Capstone.Payloads_DTOs.NewReservationDTO;
import Personal.Capstone.Services.HotelService;
import Personal.Capstone.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    public ReservationService reservationService;


    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    Page<Reservation> getAllReservations(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        return reservationService.getAllReservations(page, size);
    }

    @GetMapping("/id={id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    Reservation findReservationById(@PathVariable long id) {
        return reservationService.findReservationById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Reservation saveReservation(@RequestBody @Validated NewReservationDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            try {
                return reservationService.saveReservation(body);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @PutMapping("/modify/id={id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Reservation findReservationByIdAndUpdate(@PathVariable long id, @RequestBody Reservation body) {
        return reservationService.findReservationByIdAndUpdate(id, body);
    }

    @DeleteMapping("/delete/id={id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ADMIN')")
    void findReservationByIdAndDelete(@PathVariable long id) {
        reservationService.findReservationByIdAndDelete(id);
    }
}
