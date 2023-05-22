package pl.cantabo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryDAO;
import pl.cantabo.database.song.songCategory.SongCategoryDAO;
import pl.cantabo.database.song.songCategory.SongCategoryRepository;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class SongCategoryService {

    private final SongCategoryRepository songCategoryRepository;

    @Transactional
    public SongCategoryDAO create(SongCategoryDAO songCategory) {
        log.debug("Creating song category {}", songCategory);
        validateSongCategory(songCategory, false);
        return log.traceExit(songCategoryRepository.save(songCategory));
    }

    @Transactional
    public SongCategoryDAO update(UUID id, SongCategoryDAO songCategory) {
        log.debug("Updating song category {}: {}", id, songCategory);
        boolean isSameCategory = checkIfSameCategory(id, songCategory);
        validateSongCategory(songCategory, isSameCategory);
        SongCategoryDAO toUpdate = songCategoryRepository.findById(id).orElseThrow(() -> new ValidationException("Kategoria pieśni o podanym id nie istnieje"));
        toUpdate.setName(songCategory.getName());
        return log.traceExit(songCategoryRepository.save(toUpdate));
    }

    private boolean checkIfSameCategory(UUID id, SongCategoryDAO songCategory) {
        Optional<SongCategoryDAO> foundCategory = songCategoryRepository.findByName(songCategory.getName());
        return foundCategory.isPresent() && foundCategory.get().getId().equals(id);
    }

    private void validateSongCategory(SongCategoryDAO songCategory, boolean isSameCategory) {
        List<String> validationErrors = new ArrayList<>();

        if (songCategory.getName() == null || songCategory.getName().isEmpty()) {
            validationErrors.add("Nazwa kategorii pieśni nie może być pusta\n");
        }

        if (!isSameCategory) {
            if (songCategoryRepository.findByName(songCategory.getName()).isPresent()) {
                validationErrors.add("Kategoria pieśni o podanej nazwie już istnieje\n");
            }
        }

        if (!validationErrors.isEmpty()) {
            String errorMessage = String.join("", validationErrors);
            throw new ValidationException(errorMessage);
        }
    }

    public void delete(UUID id) {
        log.debug("Deleting song category {}", id);
        songCategoryRepository.deleteById(id);
    }

    public List<SongCategoryDAO> getAll() {
        log.debug("Getting all song categories");
        return log.traceExit(songCategoryRepository.findAll());
    }
}
