package pl.cantabo.database.profile;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ProfileUpdateDTO {

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    private boolean active;

    private boolean sortByUsed;

    private int bgColor;

    private int txColor;

    private int stopColor;

    private String fontStyle;

    private float margin;

    private float maxFont;

    private float maxMin;

    private String align;

    private String algorithmRange;

    private boolean showTitle;

    private boolean allBig;

    private boolean showEmptySlide;

    private boolean invertColors;

    private boolean expandedList;
}
