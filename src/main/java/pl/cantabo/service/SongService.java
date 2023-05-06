package pl.cantabo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.cantabo.database.song.SongDAO;
import pl.cantabo.database.song.SongRepository;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    public SongDAO create(SongDAO song) {
        log.debug("Creating song {}", song);
        return log.traceExit(songRepository.save(song));
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
