package pl.cantabo.database.playlist.group;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class GroupUpdateDTO {

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

}
