package pl.cantabo.database.song;

import lombok.Data;
import pl.cantabo.database.song.songCategory.SongCategoryDAO;

import java.util.Set;
import java.util.UUID;

@Data
public class SongInfoDTO {

    private UUID id;

    private String name;

    private String musicAuthor;

    private String wordsAuthor;

    private Set<SongCategoryDAO> songCategories;
}
