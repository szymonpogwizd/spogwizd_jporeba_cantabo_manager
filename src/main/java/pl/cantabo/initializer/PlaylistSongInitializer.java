package pl.cantabo.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.playlist.PlaylistRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PlaylistSongInitializer {

    private final PlaylistRepository playlistRepository;

    public void initialize() {
        playlistRepository.insertPlaylistSong(
                UUID.fromString("e0a1cd9f-fafd-4766-af94-489ec23006d8"),
                UUID.fromString("03795b7f-1ffc-4d46-a012-171d63f34d8e")
        );

        playlistRepository.insertPlaylistSong(
                UUID.fromString("e0a1cd9f-fafd-4766-af94-489ec23006d8"),
                UUID.fromString("5e66a7cd-4f7a-4f14-a66b-96bde53627d1")
        );

        playlistRepository.insertPlaylistSong(
                UUID.fromString("e0a1cd9f-fafd-4766-af94-489ec23006d8"),
                UUID.fromString("4f6b7d3d-3490-4eb7-a1c5-2c948d8a2c50")
        );

        playlistRepository.insertPlaylistSong(
                UUID.fromString("e0a1cd9f-fafd-4766-af94-489ec23006d8"),
                UUID.fromString("1e5dccfd-022b-40d7-87af-5809bdb137a0")
        );
    }
}
