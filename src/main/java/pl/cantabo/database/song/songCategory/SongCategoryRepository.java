package pl.cantabo.database.song.songCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.cantabo.database.song.SongDAO;

import java.util.List;
import java.util.UUID;

@Repository
public interface SongCategoryRepository extends JpaRepository<SongCategoryDAO, UUID> {

    @Query("SELECT sc FROM SongCategoryDAO sc WHERE sc.name LIKE %:nameFragment%")
    List<SongCategoryDAO> findSongCategoryByName(String nameFragment);

//    @Query("SELECT sc FROM SongCategoryDAO sc WHERE sc.song = :song")
//    List<SongCategoryDAO> findSongCategoryBySong(@Param("song") SongDAO songDAO);
}
