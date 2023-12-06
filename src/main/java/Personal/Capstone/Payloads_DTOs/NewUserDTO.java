package Personal.Capstone.Payloads_DTOs;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record NewUserDTO(
        @NotEmpty(message = "Username is required")
        @Size(min = 3, max = 30, message = "Username must be beetween 3 and 30 characters long")
        String username,

        @NotEmpty(message = "Email is required")
        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email is invalid")
        String email,
        @NotEmpty(message = "First Name is required")
        String firstName,
        @NotEmpty(message = "Last Name is required")
        String lastName,
        String password
) {

    public NewUserDTO {
    }
}
