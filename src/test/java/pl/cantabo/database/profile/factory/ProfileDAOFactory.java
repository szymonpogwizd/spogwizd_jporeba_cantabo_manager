package pl.cantabo.database.profile.factory;

import pl.cantabo.database.profile.ProfileDAO;

public class ProfileDAOFactory {

    public static final String NAME = "Test Profile";
    public static final boolean ACTIVE = false;
    public static final boolean SORT_BY_USED = false;
    public static final int BG_COLOR = 0;
    public static final int TX_COLOR = 0;
    public static final int STOP_COLOR = 0;
    public static final String FONT_STYLE = "Arial";
    public static final float MARGIN = 0.0f;
    public static final float MAX_FONT = 0.0f;
    public static final float MAX_MIN = 0.0f;
    public static final String ALIGN = "center";
    public static final String ALGORITHM_RANGE = "50";
    public static final boolean SHOW_TITLE = false;
    public static final boolean ALL_BIG = false;
    public static final boolean SHOW_EMPTY_SLIDE = false;
    public static final boolean INVERT_COLORS = false;
    public static final boolean EXPANDED_LIST = false;
    public static final boolean DEFAULT_ITEM = false;

    public static ProfileDAO.ProfileDAOBuilder defaultBuilder() {
        return ProfileDAO.builder()
                .name(NAME)
                .active(ACTIVE)
                .sortByUsed(SORT_BY_USED)
                .bgColor(BG_COLOR)
                .txColor(TX_COLOR)
                .stopColor(STOP_COLOR)
                .fontStyle(FONT_STYLE)
                .margin(MARGIN)
                .maxFont(MAX_FONT)
                .maxMin(MAX_MIN)
                .align(ALIGN)
                .algorithmRange(ALGORITHM_RANGE)
                .showTitle(SHOW_TITLE)
                .allBig(ALL_BIG)
                .showEmptySlide(SHOW_EMPTY_SLIDE)
                .invertColors(INVERT_COLORS)
                .expandedList(EXPANDED_LIST)
                .defaultItem(DEFAULT_ITEM);
    }
}
