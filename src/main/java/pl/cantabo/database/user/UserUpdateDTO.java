package pl.cantabo.database.user;

import lombok.Data;
import pl.cantabo.validator.email.Email;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserUpdateDTO {

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    @NotBlank
    private UserType userType;

    @Email
    private String email;

    private Boolean active;
}
