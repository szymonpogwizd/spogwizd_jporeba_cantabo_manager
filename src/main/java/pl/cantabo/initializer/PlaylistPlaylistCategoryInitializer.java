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

        // Droga Krzyżowa
        playlistCategoryRepository.insertPlaylistPlaylistCategory(
                UUID.fromString("2d0ea284-1288-4c8c-8bfb-0810a0f633de"),
                UUID.fromString("d2f7f61f-7173-4f72-b07a-64c8af5e5e06")
        );
    }
}
