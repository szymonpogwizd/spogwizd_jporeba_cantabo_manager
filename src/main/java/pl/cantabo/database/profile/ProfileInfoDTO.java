package pl.cantabo.database.profile;

import lombok.Data;

import java.util.UUID;

@Data
public class ProfileInfoDTO {

    private UUID id;

    private String name;

    private boolean active;

    private boolean sortByUsed;

    private int bgColor;

    private int txColor;

    private int stopColor;

    private String fontStyle;

    private double margin;

    private double maxFont;

    private double maxMin;

    private String align;

    private String algorithmRange;

    private boolean showTitle;

    private boolean allBig;

    private boolean showEmptySlide;

    private boolean invertColors;

    private boolean expandedList;
}
