package pl.cantabo.database.user;

import lombok.Data;
import pl.cantabo.validator.email.Email;
import pl.cantabo.validator.password.Password;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserCreateDTO {

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank
    private UserType userType;

    @Email
    private String email;

    @Password
    private String password;

    private Boolean active;
}
