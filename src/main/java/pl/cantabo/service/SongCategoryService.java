package pl.cantabo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.cantabo.database.song.songCategory.SongCategoryDAO;
import pl.cantabo.database.song.songCategory.SongCategoryRepository;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class SongCategoryService {

    private final SongCategoryRepository songCategoryRepository;

    public SongCategoryDAO create(SongCategoryDAO songCategory) {
        log.debug("Creating song category {}", songCategory);
        return log.traceExit(songCategoryRepository.save(songCategory));
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
