package Personal.Capstone.Payloads_DTOs;

import Personal.Capstone.Entities.Hotel;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.Period;

public record NewReservationDTO (
        @NotNull(message = "Reservation start date is required")
        LocalDate reservation_start,
        @NotNull(message = "Reservation end date is required")
        LocalDate reservation_end,
        @NotNull(message = "Hotelid is required")
        long hotelid
) {
}
