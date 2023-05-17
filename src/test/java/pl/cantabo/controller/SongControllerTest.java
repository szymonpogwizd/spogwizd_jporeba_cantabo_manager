package pl.cantabo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import pl.cantabo.database.configuration.MapperConfiguration;
import pl.cantabo.database.song.SongDAO;
import pl.cantabo.database.song.factory.SongDAOFactory;
import pl.cantabo.database.song.songCategory.SongCategoryDAO;
import pl.cantabo.database.song.songCategory.factory.SongCategoryDAOFactory;
import pl.cantabo.service.*;

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
class SongControllerTest {

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
    public void getAll() throws Exception {
        // given
        List<SongDAO> givenSongs = SongDAOFactory.defaultList();
        given(songService.getAll()).willReturn(givenSongs);

        // when
        // then
        mockMvc.perform(get("/dashboard/songs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(givenSongs.size())));
    }

    @Test
    public void getAllCategories() throws Exception {
        // given
        List<SongCategoryDAO> givenSongCategories = SongCategoryDAOFactory.defaultList();
        given(songCategoryService.getAll()).willReturn(givenSongCategories);

        // when
        // then
        mockMvc.perform(get("/dashboard/songs/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(givenSongCategories.size())));
    }

    @Test
    public void deleteSong() throws Exception {
        // given
        doNothing().when(songService).delete(any());

        // when
        // then
        mockMvc.perform(delete("/dashboard/songs/" + UUID.randomUUID()))
                .andExpect(status().isOk());
    }
}