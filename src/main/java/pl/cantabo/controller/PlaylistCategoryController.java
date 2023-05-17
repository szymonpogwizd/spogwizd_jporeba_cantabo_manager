package pl.cantabo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryCreateDTO;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryDAO;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryInfoDTO;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryMapper;
import pl.cantabo.service.PlaylistCategoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping("/dashboard/playlistCategories")
@RequiredArgsConstructor
@CrossOrigin
public class PlaylistCategoryController {

    private final PlaylistCategoryService playlistCategoryService;
    private final PlaylistCategoryMapper playlistCategoryMapper;

    @PostMapping
    public PlaylistCategoryInfoDTO createPlaylistCategory(@RequestBody @Valid PlaylistCategoryCreateDTO playlistCategory) {
        log.debug("Create playlist category {}", playlistCategory);
        PlaylistCategoryDAO toCreate = playlistCategoryMapper.playlistCategoryCreateDTO2PlaylistCategoryDAO(playlistCategory);
        PlaylistCategoryDAO createdSongCategory = playlistCategoryService.create(toCreate);
        return log.traceExit(playlistCategoryMapper.playlistCategoryDAO2PlaylistCategoryInfoDTO(createdSongCategory));
    }

    @GetMapping
    public List<PlaylistCategoryInfoDTO> getAllCategories() {
        log.debug("Getting all playlist categories");
        return log.traceExit(
                playlistCategoryService.getAll()
                        .stream()
                        .map(playlistCategoryMapper::playlistCategoryDAO2PlaylistCategoryInfoDTO)
                        .collect(Collectors.toList())
        );
    }

    @DeleteMapping("{id}")
    public void deleteSongCategory(@PathVariable UUID id) {
        log.debug("Deleting playlist category {}", id);
        playlistCategoryService.delete(id);
    }
}
