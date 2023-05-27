package pl.cantabo.database.slide;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SlideRepository extends JpaRepository<SlideDAO, UUID> {

    @Query("SELECT s FROM SlideDAO s WHERE s.song.id = :songId")
    List<SlideDAO> findSlidesBySongId(@Param("songId") UUID songId);

    @Transactional
    @Modifying
    @Query("DELETE FROM SlideDAO s WHERE s.song.id = :songId")
    void deleteSlidesBySongId(@Param("songId") UUID songId);
}
