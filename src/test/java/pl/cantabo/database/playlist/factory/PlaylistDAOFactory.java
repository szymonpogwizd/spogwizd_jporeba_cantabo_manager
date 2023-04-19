package pl.cantabo.database.playlist.factory;

import pl.cantabo.database.playlist.PlaylistDAO;

public class PlaylistDAOFactory {
    public static final String NAME = "test playlist";
    public static final Boolean DEFAULTITEM  = true;


    public static PlaylistDAO.PlaylistDAOBuilder defaultBuilder(){
        return PlaylistDAO.builder()
                .name(NAME)
                .defaultItem(DEFAULTITEM);

    }

}