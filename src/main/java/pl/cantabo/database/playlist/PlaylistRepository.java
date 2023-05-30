package pl.cantabo.database.playlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistDAO, UUID> {

    Optional<PlaylistDAO> findByName(String name);

    @Query("SELECT COUNT(p) FROM PlaylistDAO p")
    int countPlaylists();

    @Modifying
    @Query(value = "INSERT INTO playlists (id, name, default_item) " +
            "VALUES (:id, :name, :defaultItem) ON CONFLICT DO NOTHING", nativeQuery = true)
    void insertPlaylist(
            @Param("id") UUID id,
            @Param("name") String name,
            @Param("defaultItem") boolean defaultItem
    );
}
