package pl.cantabo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import pl.cantabo.database.song.*;
import pl.cantabo.service.SongService;

import javax.validation.Valid;
import java.util.UUID;

@Log4j2
@RestController
@RequestMapping("/dashboard/songManager")
@RequiredArgsConstructor
@CrossOrigin
public class SongManagerController {

    private final SongService songService;
    private final SongMapper songMapper;

    @PostMapping
    public SongInfoDTO createSong(@RequestBody @Valid SongCreateDTO song) {
        log.debug("Create song {}", song);
        SongDAO toCreate = songMapper.songCreateDTO2SongDAO(song);
        SongDAO createdSong = songService.create(toCreate);
        return log.traceExit(songMapper.songDAO2SongInfoDTO(createdSong));
    }

    @PutMapping("{id}")
    public SongInfoDTO updateSong(@RequestBody @Valid SongUpdateDTO song, @PathVariable UUID id) {
        log.debug("Update song {}: {}", id, song);
        SongDAO updatedSong = songService.update(id, songMapper.songUpdateDTO2SongDAO(song));
        return log.traceExit(songMapper.songDAO2SongInfoDTO(updatedSong));
    }
}
