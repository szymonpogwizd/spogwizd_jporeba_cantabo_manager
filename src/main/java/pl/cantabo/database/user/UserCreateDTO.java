package pl.cantabo.database.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserCreateDTO {

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank
    @Size(min = 2, max = 100)
    private String type;

    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 100)
    private String password;

    private Boolean active;
}
