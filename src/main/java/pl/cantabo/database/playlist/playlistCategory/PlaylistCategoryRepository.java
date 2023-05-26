package pl.cantabo.database.playlist.playlistCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlaylistCategoryRepository extends JpaRepository<PlaylistCategoryDAO, UUID> {

    Optional<PlaylistCategoryDAO> findByName(String name);

    @Query("SELECT pc FROM PlaylistCategoryDAO pc JOIN pc.playlists p WHERE p.id = :playlistId")
    List<PlaylistCategoryDAO> findPlaylistCategoriesByPlaylistId(UUID playlistId);
}

