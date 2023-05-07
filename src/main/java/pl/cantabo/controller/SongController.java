package pl.cantabo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import pl.cantabo.database.song.SongInfoDTO;
import pl.cantabo.database.song.SongMapper;
import pl.cantabo.database.song.songCategory.SongCategoryInfoDTO;
import pl.cantabo.database.song.songCategory.SongCategoryMapper;
import pl.cantabo.service.SongCategoryService;
import pl.cantabo.service.SongService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping("/dashboard/songs")
@RequiredArgsConstructor
@CrossOrigin
public class SongController {

    private final SongService songService;
    private final SongCategoryService songCategoryService;
    private final SongMapper songMapper;
    private final SongCategoryMapper songCategoryMapper;

    @GetMapping
    public List<SongInfoDTO> getAll() {
        log.debug("Getting all songs");
        return log.traceExit(
                songService.getAll()
                        .stream()
                        .map(songMapper::songDAO2SongInfoDTO)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/categories")
    public List<SongCategoryInfoDTO> getAllCategories() {
        log.debug("Getting all song categories");
        return log.traceExit(
                songCategoryService.getAll()
                        .stream()
                        .map(songCategoryMapper::songCategoryDAO2SongCategoryInfoDTO)
                        .collect(Collectors.toList())
        );
    }

    @DeleteMapping("{id}")
    public void deleteSong(@PathVariable UUID id) {
        log.debug("Deleting song {}", id);
        songService.delete(id);
    }
}
