package pl.cantabo.database.slide;

import lombok.Data;

@Data
public class SlideInfoDTO {

    private String body;

    private boolean defaultItem;

    private Integer itemOrder;
}
