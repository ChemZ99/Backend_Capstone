package Personal.Capstone.Services;

import Personal.Capstone.Entities.Hotel;
import Personal.Capstone.Exceptions.BadRequestException;
import Personal.Capstone.Exceptions.NotFoundException;
import Personal.Capstone.Payloads_DTOs.NewHotelDTO;
import Personal.Capstone.Repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepo;

    public Hotel saveHotel(NewHotelDTO hotelDTO) throws IOException {
        hotelRepo.findByName(hotelDTO.name()).ifPresent(hotel -> {
            throw new BadRequestException("hotel with name " + hotel.getName() + " is already in the database");
        });
        Hotel newHotel = new Hotel();
        newHotel.setName(hotelDTO.name());
        newHotel.setStars(hotelDTO.stars());
        newHotel.setHotelType(hotelDTO.hotelType());
        newHotel.setWifi(hotelDTO.wifi());
        newHotel.setBreakfast(hotelDTO.breakfast());
        newHotel.setPool(hotelDTO.pool());
        newHotel.setParking(hotelDTO.parking());
        newHotel.setWebsiteURL(hotelDTO.websiteURL());
        return hotelRepo.save(newHotel);
    }

    public Hotel findHotelById(long id) throws NotFoundException {
        return hotelRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Hotel findHotelByName(String name) throws NotFoundException {
        return hotelRepo.findByName(name).orElseThrow(() -> new RuntimeException("name not found"));
    }

    public Page<Hotel> getAllHotels(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return hotelRepo.findAll(pageable);
    }

    public Hotel findHotelByIdAndUpdate(long id, Hotel body) throws NotFoundException {
        Hotel target = this.findHotelById(id);
        target.setName(body.getName());
        target.setStars(body.getStars());
        target.setHotelType(body.getHotelType());
        target.setWifi(body.isWifi());
        target.setBreakfast(body.isBreakfast());
        target.setPool(body.isPool());
        target.setParking(body.isParking());
        target.setWebsiteURL(body.getWebsiteURL());
        return hotelRepo.save(target);
    }


    public void findHotelByIdAndDelete(long id) throws NotFoundException {
        Hotel foundHotel = this.findHotelById(id);
        hotelRepo.delete(foundHotel);
    }
}
