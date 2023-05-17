package pl.cantabo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import pl.cantabo.database.configuration.MapperConfiguration;
import pl.cantabo.database.song.SongCreateDTO;
import pl.cantabo.database.song.SongDAO;
import pl.cantabo.database.song.factory.SongDAOFactory;
import pl.cantabo.database.song.factory.SongDTOFactory;
import pl.cantabo.service.*;
import pl.cantabo.utils.JsonUtility;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = MapperConfiguration.class)
@WebMvcTest
public class SongManagerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private SongService songService;

    @MockBean
    private SongCategoryService songCategoryService;

    @MockBean
    private ProfileService profileService;

    @MockBean
    private GroupService groupService;

    @Test
    public void createSong() throws Exception {
        // given
        SongDAO songDAO = SongDAOFactory.defaultBuilder().build();
        SongCreateDTO createDTO = SongDTOFactory.defaultSongCreateDTO();
        given(songService.create(any())).willReturn(songDAO);

        // when
        // then
        mockMvc.perform(post("/dashboard/songManager")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtility.toJson(createDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(songDAO.getName())))
                .andExpect(jsonPath("$.musicAuthor", is(songDAO.getMusicAuthor())))
                .andExpect(jsonPath("$.wordsAuthor", is(songDAO.getWordsAuthor())));
    }
}
