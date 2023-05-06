package pl.cantabo.database.slide;

import lombok.Data;

import java.util.UUID;

@Data
public class SlideInfoDTO {

    private UUID id;

    private String body;

    private boolean defaultItem;

    private Integer itemOrder;
}
