package Personal.Capstone.Payloads_DTOs;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record NewUserDTO(
        @NotEmpty(message = "Il nome è un campo obbligatorio!")
        @Size(min = 3, max = 30, message = "Lo username deve essere compreso tra 3 e 30 caratteri")
        String username,

        @NotEmpty(message = "L'email è un campo obbligatorio!")
        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "L'email inserita non è valida")
        String email,
        @NotEmpty(message = "Il nome è un campo obbligatorio!")
        String firstName,
        @NotEmpty(message = "Il cognome è un campo obbligatorio!")
        String lastName,
        String password
) {

    public NewUserDTO {
    }
}
