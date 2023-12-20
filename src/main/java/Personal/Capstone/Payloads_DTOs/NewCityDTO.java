package Personal.Capstone.Payloads_DTOs;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record NewCityDTO(
        @NotEmpty(message = "City Name is required")
        @Size(min = 3, max = 30, message = "City Name must be beetween 3 and 30 characters long")
        String name,

        @NotEmpty(message = "City Province is required")
        @Size(min = 3, max = 30, message = "City Province must be beetween 3 and 30 characters long")
        String province,
        @NotEmpty(message = "City State is required")
        @Size(min = 3, max = 30, message = "City State must be beetween 3 and 30 characters long")
        String state,
        @NotNull(message = "City current population is required (you can approximate)")
        Long population
) {
}
