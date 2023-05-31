package pl.cantabo.database.slide;

import lombok.Data;
import pl.cantabo.database.song.SongDAO;

import java.util.UUID;

@Data
public class SlideInfoDTO {

    private UUID id;

    private String body;

    private Integer itemOrder;
}
