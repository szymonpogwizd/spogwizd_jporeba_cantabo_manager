package pl.cantabo.database.playlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public class PlaylistRepository extends  JpaRepository<PlaylistDAO, UUID>{
}
