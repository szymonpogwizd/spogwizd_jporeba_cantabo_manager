package pl.cantabo.database.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cantabo.utils.TokenUtility;
import pl.cantabo.utils.exception.EntityExistsException;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserService {

    @Value("${app.user.token.activation.validity-days:7}")
    private int tokenValidity;

    private final UserRepository userRepository;

    @Transactional
    public UserDAO create(UserDAO user) {
        log.debug("Creating user {}", user);
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new EntityExistsException("User " + user.getEmail() + " is already exists");
        }
        user.setActive(true);
        user.setToken(TokenUtility.generate());
        user.setTokenExpiration(ZonedDateTime.now().plusDays(tokenValidity));

        return log.traceExit(userRepository.save(user));
    }

    public void delete(UUID id) {
        log.debug("Deleting user {}", id);
        userRepository.deleteById(id);
    }

    public List<UserDAO> getAll() {
        log.debug("Getting all users");
        return log.traceExit(userRepository.findAll());
    }
}
