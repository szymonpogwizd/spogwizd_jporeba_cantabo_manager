package pl.cantabo.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryDAO;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryRepository;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PlaylistCategoryService {
    private final PlaylistCategoryRepository playlistCategoryRepository;

    public PlaylistCategoryDAO create(PlaylistCategoryDAO playlistCategory){
        log.debug("Creating playlist category{}",playlistCategory);
        validatePlaylistCategory(playlistCategory);
        return log.traceExit(playlistCategoryRepository.save(playlistCategory));
    }

    public PlaylistCategoryDAO update(UUID id, PlaylistCategoryDAO playlistCategory){
        log.debug("Updating playlist category {}: {}", id, playlistCategory);
        validatePlaylistCategory(playlistCategory);
        PlaylistCategoryDAO toUpdate = playlistCategoryRepository.findById(id).orElseThrow(() -> new ValidationException("Kategoria playlisty o podanym id nie istnieje"));
        toUpdate.setName(playlistCategory.getName());
        return log.traceExit(playlistCategoryRepository.save(toUpdate));
    }

    private void validatePlaylistCategory(PlaylistCategoryDAO playlistCategory) {
        List<String> validationErrors = new ArrayList<>();

        if (playlistCategory.getName() == null || playlistCategory.getName().isEmpty()) {
            validationErrors.add("Nazwa kategorii playlisty nie może być pusta\n");
        }

        if (playlistCategoryRepository.findByName(playlistCategory.getName()).isPresent()) {
            validationErrors.add("Kategoria playlisty o podanej nazwie już istnieje\n");
        }

        if (!validationErrors.isEmpty()) {
            String errorMessage = String.join("", validationErrors);
            throw new ValidationException(errorMessage);
        }
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
