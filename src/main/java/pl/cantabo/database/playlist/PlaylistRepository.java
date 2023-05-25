package pl.cantabo.database.playlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistDAO, UUID> {

    Optional<PlaylistDAO> findByName(String name);
}
