package pl.cantabo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import pl.cantabo.database.playlist.PlaylistDAO;
import pl.cantabo.database.playlist.PlaylistInfoDTO;
import pl.cantabo.database.playlist.PlaylistMapper;
import pl.cantabo.database.playlist.PlaylistUpdateDTO;
import pl.cantabo.service.PlaylistService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping("/dashboard/playlist")
@RequiredArgsConstructor
@CrossOrigin
public class PlaylistController {

    private final PlaylistService playlistService;
    private final PlaylistMapper playlistMapper;

    @PutMapping("{id}")
    public PlaylistInfoDTO updatePlaylist(@RequestBody @Valid PlaylistUpdateDTO playlist, @PathVariable UUID id) {
        log.debug("Update playlist {}: {}", id, playlist);
        PlaylistDAO updatedPlaylist = playlistService.update(id, playlistMapper.playlistUpdateDTO2PlaylistDAO(playlist));
        return log.traceExit(playlistMapper.playlistDAO2PlaylistInfoDTO(updatedPlaylist));
    }

    @DeleteMapping("{id}")
    public void deletePlaylist(@PathVariable UUID id) {
        log.debug("Deleting playlist {}", id);
        playlistService.delete(id);
    }

    @GetMapping
    public List<PlaylistInfoDTO> getAll() {
        log.debug("Getting all playlists");
        return log.traceExit(
                playlistService.getAll()
                        .stream()
                        .map(playlistMapper::playlistDAO2PlaylistInfoDTO)
                        .collect(Collectors.toList())
        );
    }
}
