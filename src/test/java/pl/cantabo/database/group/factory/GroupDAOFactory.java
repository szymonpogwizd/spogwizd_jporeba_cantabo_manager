package pl.cantabo.database.group.factory;

import pl.cantabo.database.group.GroupDAO;

import java.util.UUID;

public class GroupDAOFactory {

    public static  final Boolean DEFAULTITEM = true;
    public static final String  NAME =  null;


    public static GroupDAO.GroupDAOBuilder defaultBuilder(){
        return GroupDAO.builder()
                .defaultItem(DEFAULTITEM)
                .name(NAME)
                .id(UUID.randomUUID());
    }

    public static GroupDAO defaultGroup() {
        return GroupDAO.builder().build();
    }
}
