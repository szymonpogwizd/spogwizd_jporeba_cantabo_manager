package pl.cantabo.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryRepository;
import pl.cantabo.database.song.songCategory.SongCategoryRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PlaylistPlaylistCategoryInitializer {

    private final PlaylistCategoryRepository playlistCategoryRepository;

    public void initialize() {
        // Kolędy
        playlistCategoryRepository.insertPlaylistPlaylistCategory(
                UUID.fromString("e0a1cd9f-fafd-4766-af94-489ec23006d8"),
                UUID.fromString("4d3819e0-d413-4b89-99e1-2679fbd2e792")
        );
    }
}
