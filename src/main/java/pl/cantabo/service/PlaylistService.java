package pl.cantabo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.cantabo.database.playlist.PlaylistDAO;
import pl.cantabo.database.playlist.PlaylistRepository;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    public PlaylistDAO create(PlaylistDAO playlist){
        log.debug("Creating playlist{}",playlist);
        return log.traceExit(playlistRepository.save(playlist));
    }

    public void delete(UUID id){
        log.debug("Deleting playlist{}", id);
        playlistRepository.deleteById(id);
    }
    public List<PlaylistDAO> getAll(){
        log.debug("Getting all playlists");
        return log.traceExit(playlistRepository.findAll());
    }

}
