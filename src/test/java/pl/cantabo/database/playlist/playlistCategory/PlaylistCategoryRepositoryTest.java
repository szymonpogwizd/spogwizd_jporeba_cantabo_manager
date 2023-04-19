package pl.cantabo.database.playlist.playlistCategory.factory;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryDAO;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryRepository;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
public class PlaylistCategoryRepositoryTest {
    @Autowired
    private PlaylistCategoryRepository playlistCategoryRepository;

    @BeforeEach
    public void setUp(){
        playlistCategoryRepository.deleteAll();
    }

    @Test
    public void savePlaylistCategoryTest(){
        //given
        PlaylistCategoryDAO playlistCategoryDAO = PlaylistCategoryDAOFactory.defaultBuilder().build();
        //when
        PlaylistCategoryDAO savedPlaylistCategoryDAO = playlistCategoryRepository.saveAndFlush(playlistCategoryDAO);
        //then
        assertNotNull(savedPlaylistCategoryDAO.getId());
        assertEquals(playlistCategoryDAO, savedPlaylistCategoryDAO);
    }
    @Test
    public void updatePlaylistCategoryTest(){
        //given
        PlaylistCategoryDAO playlistCategoryDAO = PlaylistCategoryDAOFactory.defaultBuilder().build();
        playlistCategoryDAO.setName("old Name");
        //when
        playlistCategoryRepository.saveAndFlush(playlistCategoryDAO);
        playlistCategoryDAO.setName("new Name");
        PlaylistCategoryDAO savedPlaylistCategoryDAO = playlistCategoryRepository.saveAndFlush(playlistCategoryDAO);
        //then
        assertNotNull(savedPlaylistCategoryDAO);
        assertEquals(playlistCategoryDAO.getId(), savedPlaylistCategoryDAO.getId());
        assertEquals("New Name", savedPlaylistCategoryDAO.getName());
    }
    @Test
    public void deletePlaylistCategory(){
        //given
        PlaylistCategoryDAO playlistCategoryDAO = PlaylistCategoryDAOFactory.defaultBuilder().build();
        playlistCategoryRepository.saveAndFlush(playlistCategoryDAO);
        //when
        playlistCategoryRepository.delete(playlistCategoryDAO);
        Optional<PlaylistCategoryDAO> deletedPlaylistCategoryDAO = playlistCategoryRepository.findById(playlistCategoryDAO.getId());
        //then
        assertFalse(deletedPlaylistCategoryDAO.isPresent());
    }
    @Test
    public void findAllPlaylistCategoryTest(){
        //given
        PlaylistCategoryDAO playlistCategoryDAO1 = PlaylistCategoryDAOFactory.defaultBuilder().build();
        PlaylistCategoryDAO playlistCategoryDAO2 = PlaylistCategoryDAOFactory.defaultBuilder().build();
        //when
        playlistCategoryRepository.saveAndFlush(playlistCategoryDAO1);
        playlistCategoryRepository.saveAndFlush(playlistCategoryDAO2);
        List<PlaylistCategoryDAO> playlistCategoryDAOList = playlistCategoryRepository.findAll();
        //then
        assertEquals(2, playlistCategoryDAOList.size());
    }
    @Test
    public void findAllPlaylistCategoryByName(){
        //given
        PlaylistCategoryDAO playlistCategoryDAO1 = PlaylistCategoryDAOFactory.defaultBuilder().name("playlistCategory1").build();
        PlaylistCategoryDAO playlistCategoryDAO2 = PlaylistCategoryDAOFactory.defaultBuilder().name("playlistCategory2").build();
        //when
        playlistCategoryRepository.saveAndFlush(playlistCategoryDAO1);
        playlistCategoryRepository.saveAndFlush(playlistCategoryDAO2);
        List<PlaylistCategoryDAO> playlistCategoryDAOList = playlistCategoryRepository.findAll();
        //then
        assertEquals(2, playlistCategoryDAOList.size());
    }
    @Test
    public void findPlaylistCategoryByNameTest(){
        //given
        PlaylistCategoryDAO playlistCategoryDAO = PlaylistCategoryDAOFactory.defaultBuilder().name("playlistCategory1").build();
        PlaylistCategoryDAO playlistCategoryDAO2 = PlaylistCategoryDAOFactory.defaultBuilder().name("playlistCategory2").build();
        //when
        playlistCategoryRepository.saveAndFlush(playlistCategoryDAO);
        playlistCategoryRepository.saveAndFlush(playlistCategoryDAO2);
        List<PlaylistCategoryDAO> playlistCategory = playlistCategoryRepository.findPlaylistCategoryByName("playlistCategory");
        List<PlaylistCategoryDAO> playlistCategory1 = playlistCategoryRepository.findPlaylistCategoryByName("playlistCategory");
        //then
        assertEquals(2, playlistCategory.size());
        assertEquals(1, playlistCategory1.size());
    }

}