package pl.cantabo.database.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileDAO, UUID> {

    @Query("SELECT p FROM ProfileDAO p WHERE p.name LIKE %:nameFragment%")
    List<ProfileDAO> findProfileByName(String nameFragment);

    Optional<ProfileDAO> findByName(String name);
}
