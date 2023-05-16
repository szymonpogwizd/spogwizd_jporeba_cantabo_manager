package pl.cantabo.database.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, UUID> {

    List<UserDAO> findByUserType(UserType userType);

    Optional<UserDAO> findByEmail(String email);

    Optional<UserDAO> findByName(String name);

    @Query("SELECT u FROM UserDAO u WHERE u.name LIKE %:fragment% OR u.email LIKE %:fragment%")
    List<UserDAO> findByUserNameOrEmail(String fragment);
}
