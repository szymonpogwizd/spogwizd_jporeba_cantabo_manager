package pl.cantabo.database;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserUpdateDTO {

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    @NotBlank
    @Size(min = 1, max = 100)
    private String type;

    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 100)
    private String password;

    private Boolean active;
}
