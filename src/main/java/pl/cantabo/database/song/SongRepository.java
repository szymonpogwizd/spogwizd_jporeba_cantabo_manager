package pl.cantabo.database.song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SongRepository extends JpaRepository<SongDAO, UUID> {

    Optional<SongDAO> findByName(String name);

    @Query("SELECT s FROM SongDAO s JOIN s.playlists p WHERE p.id = :playlistId")
    List<SongDAO> findSongsByPlaylistId(@Param("playlistId") UUID playlistId);
}
