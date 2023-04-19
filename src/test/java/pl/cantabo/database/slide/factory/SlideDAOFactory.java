package pl.cantabo.database.slide.factory;

import pl.cantabo.database.slide.SlideDAO;

public class SlideDAOFactory {
    public static final Integer ORDER = 15;
    public static String BODY = "test body";

    public static Boolean DEFAULTITEM = true;

    public static SlideDAO.SlideDAOBuilder defaultBiulder() {
        return SlideDAO.builder()
                .itemOrder(ORDER)
                .body(BODY)
                .defaultItem(DEFAULTITEM);

    }

}
