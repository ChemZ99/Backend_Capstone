package Personal.Capstone.Payloads_DTOs;

import Personal.Capstone.Entities.Hotel_Type;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewHotelDTO(
        @NotEmpty(message = "Hotel Name is required")
        @Size(min = 3, max = 30, message = "Hotel Name must be beetween 3 and 30 characters long")
        String name,
        @NotNull(message = "Hotel stars are required")
        int stars,
        Hotel_Type hotelType,
        boolean wifi,
        boolean breakfast,
        boolean pool,
        boolean parking,
        String websiteURL
) {
}
