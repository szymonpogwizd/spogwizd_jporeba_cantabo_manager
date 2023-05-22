package pl.cantabo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cantabo.database.playlist.PlaylistDAO;
import pl.cantabo.database.playlist.PlaylistRepository;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    @Transactional
    public PlaylistDAO create(PlaylistDAO playlist){
        log.debug("Creating playlist{}",playlist);
        validatePlaylist(playlist, false);
        return log.traceExit(playlistRepository.save(playlist));
    }

    @Transactional
    public PlaylistDAO update(UUID id, PlaylistDAO playlist){
        log.debug("Updating playlist {}: {}", id, playlist);
        boolean isSamePlaylist = checkIfSamePlaylist(id, playlist);
        validatePlaylist(playlist, isSamePlaylist);
        PlaylistDAO toUpdate = playlistRepository.findById(id).orElseThrow(() -> new ValidationException("Playlist o podanym id nie istnieje"));
        toUpdate.setName(playlist.getName());
        return log.traceExit(playlistRepository.save(toUpdate));
    }

    private boolean checkIfSamePlaylist(UUID id, PlaylistDAO playlist) {
        Optional<PlaylistDAO> foundPlaylist = playlistRepository.findByName(playlist.getName());
        return foundPlaylist.isPresent() && foundPlaylist.get().getId().equals(id);
    }

    private void validatePlaylist(PlaylistDAO playlist, boolean isSamePlaylist) {
        List<String> validationErrors = new ArrayList<>();

        if (playlist.getName() == null || playlist.getName().isEmpty()) {
            validationErrors.add("Nazwa playlisty nie może być pusta\n");
        }

        if (!isSamePlaylist) {
            if (playlistRepository.findByName(playlist.getName()).isPresent()) {
                validationErrors.add("Playlista o podanej nazwie już istnieje\n");
            }
        }

        if (!validationErrors.isEmpty()) {
            String errorMessage = String.join("", validationErrors);
            throw new ValidationException(errorMessage);
        }
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
