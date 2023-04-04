package pl.cantabo.database.user.factory;

import pl.cantabo.database.user.UserDAO;
import pl.cantabo.database.user.UserType;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class UserDAOFactory {

    public static final Boolean ACTIVE = true;
    public static final String EMAIL = "test@example.com";
    public static final UserType USER_TYPE = UserType.USER;
    public static final String NAME = "Test User";
    public static final String TOKEN = UUID.randomUUID().toString();
    public static final ZonedDateTime EXPIRATION = ZonedDateTime.now().plusDays(1);

    public static UserDAO.UserDAOBuilder defaultBuilder() {
        return UserDAO.builder()
                .active(ACTIVE)
                .email(EMAIL)
                .type(USER_TYPE)
                .name(NAME)
                .token(TOKEN)
                .tokenExpiration(EXPIRATION)
                .id(UUID.randomUUID());
    }

    public static UserDAO defaultUser() {
        return UserDAO.builder().build();
    }

    public static List<UserDAO> defaultList() {
        return List.of(
                defaultBuilder().email("test1@example.com").build(),
                defaultBuilder().email("test2@example.com").build()
        );
    }
}
