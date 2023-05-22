package pl.cantabo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cantabo.database.song.SongDAO;
import pl.cantabo.database.song.SongRepository;
import pl.cantabo.database.user.UserDAO;
import pl.cantabo.validator.email.EmailValidator;
import pl.cantabo.validator.email.EmailValidatorException;
import pl.cantabo.validator.password.PasswordValidator;
import pl.cantabo.validator.password.PasswordValidatorException;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    @Transactional
    public SongDAO create(SongDAO song) {
        log.debug("Creating song {}", song);
        validateSong(song, false);
        return log.traceExit(songRepository.save(song));
    }

    @Transactional
    public SongDAO update(UUID id, SongDAO song) {
        log.debug("Updating song {}: {}", id, song);
        boolean isSameSong = checkIfSameSong(id, song);
        validateSong(song, isSameSong);
        SongDAO toUpdate = songRepository.findById(id).orElseThrow(() -> new ValidationException("Pieśń o podanym id nie istnieje"));
        toUpdate.setName(song.getName());
        toUpdate.setMusicAuthor(song.getMusicAuthor());
        toUpdate.setWordsAuthor(song.getWordsAuthor());
        toUpdate.setSongCategories(song.getSongCategories());
        return log.traceExit(songRepository.save(toUpdate));
    }

    private boolean checkIfSameSong(UUID id, SongDAO song) {
        Optional<SongDAO> foundSong = songRepository.findByName(song.getName());
        return foundSong.isPresent() && foundSong.get().getId().equals(id);
    }

    private void validateSong(SongDAO song, boolean isSameSong) {
        List<String> validationErrors = new ArrayList<>();

        if (song.getName() == null || song.getName().isEmpty()) {
            validationErrors.add("Nazwa pieśni nie może być pusta\n");
        }

        if (!isSameSong) {
            if (songRepository.findByName(song.getName()).isPresent()) {
                validationErrors.add("Pieśń o podanej nazwie już istnieje\n");
            }
        }

        if (!validationErrors.isEmpty()) {
            String errorMessage = String.join("", validationErrors);
            throw new ValidationException(errorMessage);
        }
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
