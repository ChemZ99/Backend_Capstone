package Personal.Capstone.Services;

import Personal.Capstone.Entities.Hotel;
import Personal.Capstone.Entities.Reservation;
import Personal.Capstone.Exceptions.BadRequestException;
import Personal.Capstone.Exceptions.NotFoundException;
import Personal.Capstone.Payloads_DTOs.NewHotelDTO;
import Personal.Capstone.Payloads_DTOs.NewReservationDTO;
import Personal.Capstone.Repositories.HotelRepository;
import Personal.Capstone.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepo;

    @Autowired
    private HotelService hotelService;

    public Reservation saveReservation(NewReservationDTO reservationDTO) throws IOException {

        Reservation newReservation = new Reservation();
        newReservation.setReservation_start(reservationDTO.reservation_start());
        newReservation.setReservation_end(reservationDTO.reservation_end());
        newReservation.setPeriod(reservationDTO.period());
        newReservation.setHotel(hotelService.findHotelById(reservationDTO.hotelid()));
        return reservationRepo.save(newReservation);
    }

    public Reservation findReservationById(long id) throws NotFoundException {
        return reservationRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Page<Reservation> getAllReservations(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return reservationRepo.findAll(pageable);
    }

    public Reservation findReservationByIdAndUpdate(long id, Reservation body) throws NotFoundException {
        Reservation target = this.findReservationById(id);
        target.setReservation_start(body.getReservation_start());
        target.setReservation_end(body.getReservation_end());
        target.setPeriod(body.getPeriod());
        target.setHotel(body.getHotel());
        return reservationRepo.save(target);
    }


    public void findReservationByIdAndDelete(long id) throws NotFoundException {
        Reservation foundReservation = this.findReservationById(id);
        reservationRepo.delete(foundReservation);
    }
}
