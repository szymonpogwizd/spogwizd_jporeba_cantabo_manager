package pl.cantabo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cantabo.database.song.SongDAO;
import pl.cantabo.database.song.SongRepository;
import pl.cantabo.validator.SongValidator;

import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final SongValidator songValidator;

    @Transactional
    public SongDAO create(SongDAO song) {
        log.debug("Creating song {}", song);
        songValidator.validateSong(song, false);
        return log.traceExit(songRepository.save(song));
    }

    @Transactional
    public SongDAO update(UUID id, SongDAO song) {
        log.debug("Updating song {}: {}", id, song);
        boolean isSameSong = songValidator.checkIfSameSong(id, song);
        songValidator.validateSong(song, isSameSong);
        SongDAO toUpdate = songRepository.findById(id).orElseThrow(() -> new ValidationException("Pieśń o podanym id nie istnieje"));
        toUpdate.setName(song.getName());
        toUpdate.setMusicAuthor(song.getMusicAuthor());
        toUpdate.setWordsAuthor(song.getWordsAuthor());
        toUpdate.setSongCategories(song.getSongCategories());
        return log.traceExit(songRepository.save(toUpdate));
    }

    public void delete(UUID id) {
        log.debug("Deleting song {}", id);
        songRepository.deleteById(id);
    }

    public List<SongDAO> getAll() {
        log.debug("Getting all songs");
        return log.traceExit(songRepository.findAll());
    }
}
