package pl.cantabo.database.song.songCategory.factory;

import pl.cantabo.database.song.songCategory.SongCategoryDAO;

public class SongCategoryDAOFactory {

    public static final String NAME = "Test Song Category";
    public static final boolean DEFAULT_ITEM = true;

    public static SongCategoryDAO.SongCategoryDAOBuilder defaultBuilder() {
        return SongCategoryDAO.builder()
                .name(NAME)
                .defaultItem(DEFAULT_ITEM)
                .songs(null)
                .groups(null);
    }
}
