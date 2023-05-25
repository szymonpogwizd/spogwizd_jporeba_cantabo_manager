package pl.cantabo.controller;

import lombok.Data;
import pl.cantabo.database.slide.SlideCreateDTO;
import pl.cantabo.database.song.SongCreateDTO;

import javax.validation.Valid;
import java.util.Set;

@Data
public class SongAndCreateRequestDTO {
    @Valid
    private SongCreateDTO song;

    @Valid
    private Set<SlideCreateDTO> slides;
}
