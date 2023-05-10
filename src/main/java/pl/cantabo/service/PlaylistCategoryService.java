package pl.cantabo.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryDAO;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryRepository;

import java.util.UUID;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class PlaylistCategoryService {
    private final PlaylistCategoryRepository playlistCategoryRepository;

    public PlaylistCategoryDAO create(PlaylistCategoryDAO playlistCategory){
        log.debug("Creating playlist category{}",playlistCategory);
        return log.traceExit(playlistCategoryRepository.save(playlistCategory));
    }

    public void delete(UUID id ){
        log.debug("Deleting playlist category{}", id);
        playlistCategoryRepository.deleteById(id);
    }

    public List<PlaylistCategoryDAO> getAll(){
        log.debug("Getting all playlist categories");
        return log.traceExit(playlistCategoryRepository.findAll());
    }
}
