package pl.cantabo.database.slide.factory;

import pl.cantabo.database.slide.SlideDAO;

public class SlideDAOFactory {

    public static final Integer ORDER = 15;
    public static String BODY = "test body";
    public static Boolean DEFAULT_ITEM = true;

    public static SlideDAO.SlideDAOBuilder defaultBuilder() {
        return SlideDAO.builder()
                .itemOrder(ORDER)
                .body(BODY)
                .defaultItem(DEFAULT_ITEM);
    }
}
