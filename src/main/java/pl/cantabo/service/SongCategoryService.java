package pl.cantabo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.cantabo.database.song.songCategory.SongCategoryDAO;
import pl.cantabo.database.song.songCategory.SongCategoryRepository;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class SongCategoryService {

    private final SongCategoryRepository songCategoryRepository;

    public SongCategoryDAO create(SongCategoryDAO songCategory) {
        log.debug("Creating song category {}", songCategory);
        validateSongCategory(songCategory);
        return log.traceExit(songCategoryRepository.save(songCategory));
    }

    private void validateSongCategory(SongCategoryDAO songCategory) {
        List<String> validationErrors = new ArrayList<>();

        if (songCategory.getName() == null || songCategory.getName().isEmpty()) {
            validationErrors.add("Nazwa kategorii pieśni nie może być pusta\n");
        }

        if (songCategoryRepository.findByName(songCategory.getName()).isPresent()) {
            validationErrors.add("Kategoria pieśni o podanej nazwie już istnieje\n");
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
