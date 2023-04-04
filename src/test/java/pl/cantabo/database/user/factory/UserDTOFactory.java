package pl.cantabo.database.user.factory;

import pl.cantabo.database.user.UserCreateDTO;
import pl.cantabo.database.user.UserUpdateDTO;

public class UserDTOFactory {

    public static final String PASSWORD = "Password1@";

    public static UserCreateDTO defaultUserCreateDTO() {
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setActive(UserDAOFactory.ACTIVE);
        userCreateDTO.setType(UserDAOFactory.USER_TYPE);
        userCreateDTO.setEmail(UserDAOFactory.EMAIL);
        userCreateDTO.setName(UserDAOFactory.NAME);
        userCreateDTO.setPassword(PASSWORD);

        return userCreateDTO;
    }

    public static UserUpdateDTO defaultUserUpdateDTO() {
        UserUpdateDTO userUpdateDTO = new UserUpdateDTO();
        userUpdateDTO.setActive(UserDAOFactory.ACTIVE);
        userUpdateDTO.setType(UserDAOFactory.USER_TYPE);
        userUpdateDTO.setName(UserDAOFactory.NAME);
        userUpdateDTO.setEmail(UserDAOFactory.EMAIL);

        return userUpdateDTO;
    }
}
