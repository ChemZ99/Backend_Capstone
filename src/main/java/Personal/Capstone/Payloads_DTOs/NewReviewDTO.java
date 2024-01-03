package Personal.Capstone.Payloads_DTOs;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record NewReviewDTO(
        @NotNull(message = "Evaluation is required")
        double evaluation,
        @NotEmpty(message = "Description is required")
        @Size(min = 3, max = 300, message = "Description must be beetween 3 and 300 characters long")
        String description,
        @NotNull(message = "Date of Dispatch is required")
        LocalDate date_of_dispatch,
        @NotNull(message = "userid is required")
        Long userid,
        @NotNull(message = "hotelid is required")
        Long hotelid
) {
}
