package pl.cantabo.database.playlist.playlistCategory.factory;

import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryDAO;

public class PlaylistCategoryDAOFactory {

    public static final  String NAME = "test playlistCategory";
    public static final Boolean DEFAULTITEM = true;


    public static PlaylistCategoryDAO.PlaylistCategoryDAOBuilder defaultBuilder(){
        return PlaylistCategoryDAO.builder()
                .name(NAME)
                .defaultItem(DEFAULTITEM);

    }
}
