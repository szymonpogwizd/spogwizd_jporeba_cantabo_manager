package pl.cantabo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import pl.cantabo.database.configuration.MapperConfiguration;
import pl.cantabo.database.profile.ProfileDAO;
import pl.cantabo.database.profile.factory.ProfileDAOFactory;
import pl.cantabo.service.ProfileService;
import pl.cantabo.service.SongCategoryService;
import pl.cantabo.service.SongService;
import pl.cantabo.service.UserService;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = MapperConfiguration.class)
@WebMvcTest
class ProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfileService profileService;

    @MockBean
    private UserService userService;

    @MockBean
    private SongService songService;

    @MockBean
    private SongCategoryService songCategoryService;

    @Test
    public void getAll() throws Exception {
        // given
        List<ProfileDAO> givenProfiles = ProfileDAOFactory.defaultList();
        given(profileService.getAll()).willReturn(givenProfiles);

        // when
        // then
        mockMvc.perform(get("/dashboard/profiles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(givenProfiles.size())));
    }

    @Test
    public void deleteUser() throws Exception {
        // given
        doNothing().when(profileService).delete(any());

        // when
        // then
        mockMvc.perform(delete("/dashboard/profiles/" + UUID.randomUUID()))
                .andExpect(status().isOk());
    }
}