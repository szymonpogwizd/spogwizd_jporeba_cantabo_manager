package pl.cantabo.database.song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SongRepository extends JpaRepository<SongDAO, UUID> {

    Optional<SongDAO> findByName(String name);
}
