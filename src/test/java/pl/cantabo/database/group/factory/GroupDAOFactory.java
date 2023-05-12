package pl.cantabo.database.group.factory;

import pl.cantabo.database.group.GroupDAO;

public class GroupDAOFactory {

    public static final Boolean DEFAULT_ITEM = true;
    public static final String NAME = null;

    public static GroupDAO.GroupDAOBuilder defaultBuilder() {
        return GroupDAO.builder()
                .defaultItem(DEFAULT_ITEM)
                .name(NAME);
    }
}
