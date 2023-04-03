package pl.cantabo.database.song;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SongUpdateDTO {

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    @Size(min = 1, max = 100)
    private String musicAuthor;

    @Size(min = 1, max = 100)
    private String wordsAuthor;
}
