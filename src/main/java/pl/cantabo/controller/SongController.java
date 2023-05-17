package pl.cantabo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import pl.cantabo.database.song.SongInfoDTO;
import pl.cantabo.database.song.SongMapper;
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
    private final SongMapper songMapper;

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

    @DeleteMapping("{id}")
    public void deleteSong(@PathVariable UUID id) {
        log.debug("Deleting song {}", id);
        songService.delete(id);
    }
}
