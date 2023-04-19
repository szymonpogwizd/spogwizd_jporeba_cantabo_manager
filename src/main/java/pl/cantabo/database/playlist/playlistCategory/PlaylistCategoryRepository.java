package pl.cantabo.database.playlist.playlistCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;
public class PlaylistCategoryRepository extends JpaRepository<PlaylistCategoryDAO, UUID> {
  //  @Query("Select sc FROM PlaylistCategoryDAO sc WHERE sc.name LIKE %:nameFragment%")
    // List<PlaylistCategoryDAO> findPlaylistCategoryByName(String nameFragment);

    // @Query("Select sc FROM PlaylistCategoryDAO sc WHERE sc.playlist = :playlist")
    //    List<PlaylistCategoryDAO> findPlaylistCategoryByPlaylist(@Param("playlist")PlaylistDAO playlistDAO);


}

