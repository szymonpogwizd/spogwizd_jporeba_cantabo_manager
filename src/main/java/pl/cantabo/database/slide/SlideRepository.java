package pl.cantabo.database.slide;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SlideRepository extends JpaRepository<SlideDAO, UUID> {
}
