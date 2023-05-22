package pl.cantabo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cantabo.database.user.UserDAO;
import pl.cantabo.database.user.UserRepository;
import pl.cantabo.database.user.UserType;
import pl.cantabo.utils.TokenUtility;
import pl.cantabo.validator.email.EmailValidator;
import pl.cantabo.validator.email.EmailValidatorException;
import pl.cantabo.validator.password.PasswordValidator;
import pl.cantabo.validator.password.PasswordValidatorException;

import javax.validation.ValidationException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

        validateUser(user, false);

        user.setToken(TokenUtility.generate());
        user.setTokenExpiration(ZonedDateTime.now().plusDays(tokenValidity));

        parseUserType(user);

        return log.traceExit(userRepository.save(user));
    }

    @Transactional
    public UserDAO update(UUID id, UserDAO user) {
        log.debug("Editing user {} - {}", id, user);
        boolean isSameUser = checkIfSameUser(id, user);
        validateUser(user, isSameUser);
        UserDAO toUpdate = userRepository.findById(id)
                .orElseThrow(() -> new ValidationException("User with id " + id + " was not found"));

        toUpdate.setName(user.getName());
        toUpdate.setEmail(user.getEmail());
        toUpdate.setPassword(user.getPassword());
        toUpdate.setActive(user.getActive());
        toUpdate.setGroup(user.getGroup());
        toUpdate.setToken(user.getToken());
        toUpdate.setTokenExpiration(user.getTokenExpiration());

        parseUserType(toUpdate);

        return log.traceExit(userRepository.save(toUpdate));
    }

    private boolean checkIfSameUser(UUID id, UserDAO user) {
        Optional<UserDAO> foundUserByName = userRepository.findByName(user.getName());
        Optional<UserDAO> foundUserByEmail = userRepository.findByEmail(user.getEmail());
        boolean isSameUserByName = foundUserByName.isPresent() && foundUserByName.get().getId().equals(id);
        boolean isSameUserByEmail = foundUserByEmail.isPresent() && foundUserByEmail.get().getId().equals(id);
        return isSameUserByName && isSameUserByEmail;
    }

    private void parseUserType(UserDAO user) {
        UserType userType = UserType.valueOf(String.valueOf(user.getUserType()));

        if (userType == UserType.USER) {
            user.setUserType(UserType.USER);
        } else if (userType == UserType.ADMINISTRATOR) {
            user.setUserType(UserType.ADMINISTRATOR);
        } else if (userType == UserType.SUPER_ADMINISTRATOR) {
            user.setUserType(UserType.SUPER_ADMINISTRATOR);
        }
    }

    private void validateUser(UserDAO user, boolean isSameUser) {
        List<String> validationErrors = new ArrayList<>();

        if (user.getName() == null || user.getName().isEmpty()) {
            validationErrors.add("Nazwa użytkownika nie może być pusta\n");
        }

        if (!isSameUser) {
            if (userRepository.findByName(user.getName()).isPresent()) {
                validationErrors.add("Użytkownik o podanej nazwie już istnieje\n");
            }

            if (userRepository.findByEmail(user.getEmail()).isPresent()) {
                validationErrors.add("Użytkownik o podanym adresie e-mail już istnieje\n");
            }
        }

        try {
            EmailValidator.validate(user.getEmail());
        } catch (EmailValidatorException e) {
            validationErrors.add(e.getMessage() + "\n");
        }

        try {
            PasswordValidator.validate(user.getPassword());
        } catch (PasswordValidatorException e) {
            validationErrors.add(e.getMessage() + "\n");
        }

        if (!validationErrors.isEmpty()) {
            String errorMessage = String.join("", validationErrors);
            throw new ValidationException(errorMessage);
        }
    }

    public void delete(UUID id) {
        log.debug("Deleting user {}", id);
        userRepository.deleteById(id);
    }

    public List<UserDAO> getAll() {
        log.debug("Getting all users");
        return log.traceExit(userRepository.findAll());
    }

    public List<UserType> getAllUserTypes() {
        log.debug("Getting all user types");
        return log.traceExit(List.of(UserType.values()));
    }
}
