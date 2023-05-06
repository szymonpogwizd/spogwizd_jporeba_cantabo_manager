package pl.cantabo.database.playlist;

import lombok.Data;

import java.util.UUID;

@Data
public class PlaylistInfoDTO {

    private UUID id;

    private String name;
}

