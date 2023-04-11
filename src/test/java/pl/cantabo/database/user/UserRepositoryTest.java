package pl.cantabo.database.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pl.cantabo.database.user.factory.UserDAOFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void saveUserTest() {
        // given
        UserDAO userDAO = UserDAOFactory.defaultBuilder().build();

        // when
        UserDAO savedUserDAO = userRepository.saveAndFlush(userDAO);

        // then
        assertNotNull(savedUserDAO.getId());
        assertEquals(userDAO, savedUserDAO);
    }

    @Test
    public void updateUserTest() {
        // given
        UserDAO userDAO = UserDAOFactory.defaultBuilder().build();
        userDAO.setName("oldName");

        // when
        userRepository.saveAndFlush(userDAO);
        userDAO.setName("newName");
        UserDAO savedUserDAO = userRepository.saveAndFlush(userDAO);

        // then
        assertNotNull(savedUserDAO);
        assertEquals(userDAO.getId(), savedUserDAO.getId());
        assertEquals("newName", savedUserDAO.getName());
    }

    @Test
    public void deleteUserTest() {
        // given
        UserDAO userDAO = UserDAOFactory.defaultBuilder().build();
        userRepository.saveAndFlush(userDAO);

        // when
        userRepository.delete(userDAO);
        Optional<UserDAO> deletedUserDAO = userRepository.findById(userDAO.getId());

        // then
        assertFalse(deletedUserDAO.isPresent());
    }

    @Test
    public void findByUserTypeTest() {
        // given
        UserDAO user1 = UserDAOFactory.defaultBuilder().userType(UserType.USER).build();
        UserDAO user2 = UserDAOFactory.defaultBuilder().userType(UserType.USER).build();
        UserDAO admin = UserDAOFactory.defaultBuilder().userType(UserType.ADMINISTRATOR).build();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(admin);

        // when
        List<UserDAO> userTypeUser = userRepository.findByUserType(UserType.USER);
        List<UserDAO> userTypeAdministrator = userRepository.findByUserType(UserType.ADMINISTRATOR);

        // then
        assertEquals(2, userTypeUser.size());
        assertEquals(1, userTypeAdministrator.size());
        assertTrue(userTypeUser.contains(user1));
        assertTrue(userTypeUser.contains(user2));
        assertTrue(userTypeAdministrator.contains(admin));
    }
}