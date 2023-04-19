package pl.cantabo.database.slide;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SlideCreateDTO {

    @NotBlank
    private Integer itemOrder;

    @NotBlank
    @Size(min = 1, max = 5000)
    private String body;

    private Boolean defaultItem;
}
