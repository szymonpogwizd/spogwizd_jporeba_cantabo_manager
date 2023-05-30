package pl.cantabo.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.playlist.PlaylistRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PlaylistInitializer {

    private final PlaylistRepository playlistRepository;

    public void initialize() {
        playlistRepository.insertPlaylist(
                UUID.fromString("e0a1cd9f-fafd-4766-af94-489ec23006d8"),
                "Pasterka",
                true
        );

        playlistRepository.insertPlaylist(
                UUID.fromString("2d0ea284-1288-4c8c-8bfb-0810a0f633de"),
                "Droga Krzyżowa - Wielki Piątek",
                true
        );
    }
}
