package pl.cantabo.database.playlist.playlistCategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlaylistCategoryRepository extends JpaRepository<PlaylistCategoryDAO, UUID> {

    Optional<PlaylistCategoryDAO> findByName(String name);
}

