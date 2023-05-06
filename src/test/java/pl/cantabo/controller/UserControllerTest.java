package pl.cantabo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import pl.cantabo.database.configuration.MapperConfiguration;
import pl.cantabo.database.user.UserDAO;
import pl.cantabo.database.user.UserType;
import pl.cantabo.database.user.factory.UserDAOFactory;
import pl.cantabo.service.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration(classes = MapperConfiguration.class)
@WebMvcTest
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void getAll() throws Exception {
        // given
        List<UserDAO> givenUsers = UserDAOFactory.defaultList();
        given(userService.getAll()).willReturn(givenUsers);

        // when
        // then
        mockMvc.perform(get("/dashboard/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(givenUsers.size())));
    }

    @Test
    public void shouldReturnAllUserTypes() throws Exception {
        // given
        List<UserType> userTypes = Arrays.asList(UserType.values());
        when(userService.getAllUserTypes()).thenReturn(userTypes);

        // when
        mockMvc.perform(get("/dashboard/users/userTypes"))

                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(userTypes.size())))
                .andExpect(jsonPath("$[0]").value(UserType.USER.toString()))
                .andExpect(jsonPath("$[1]").value(UserType.ADMINISTRATOR.toString()))
                .andExpect(jsonPath("$[2]").value(UserType.SUPERADMINISTRATOR.toString()));
    }

    @Test
    public void deleteUser() throws Exception {
        // given
        doNothing().when(userService).delete(any());

        // when
        // then
        mockMvc.perform(delete("/dashboard/users/" + UUID.randomUUID()))
                .andExpect(status().isOk());
    }
}