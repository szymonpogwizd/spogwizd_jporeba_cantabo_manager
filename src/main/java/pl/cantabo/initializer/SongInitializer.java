package pl.cantabo.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.song.SongRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SongInitializer {

    private final SongRepository songRepository;

    public void initialize() {
        songRepository.insertSong(
                UUID.fromString("dd51c3f7-6716-40ff-af45-d0ae81a7751b"),
                "Bliskie jest Królestwo Boże",
                0,
                true
        );

        songRepository.insertSong(
                UUID.fromString("03785b7f-1ffc-4d46-a012-171d63f34d8e"),
                "Wśród nocnej ciszy",
                0,
                true
        );

        songRepository.insertSong(
                UUID.fromString("8c9dc5e1-605c-416a-9405-57058c007076"),
                "Ach, mój Jezu",
                0,
                true
        );

        songRepository.insertSong(
                UUID.fromString("60c81edc-a645-4fa6-9413-e32c71ad96a7"),
                "Nie zna śmierci Pan żywota",
                0,
                true
        );

        songRepository.insertSong(
                UUID.fromString("1a03f4fe-a53a-435c-9a4e-fffc0819cdb0"),
                "Abba Ojcze",
                0,
                true
        );

        songRepository.insertSong(
                UUID.fromString("f4bb4062-dce9-4086-b02c-7c933d8e7745"),
                "Psalm 23",
                0,
                true
        );
    }
}
