package pl.cantabo.database.song.songCategory;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SongCategoryCreateDTO {

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;
}
