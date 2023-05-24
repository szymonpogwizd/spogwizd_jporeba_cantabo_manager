package pl.cantabo.database.playlist;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE

)
public interface PlaylistMapper {

    PlaylistInfoDTO playlistDAO2PlaylistInfoDTO(PlaylistDAO playlistDAO);

    PlaylistDAO playlistCreateDTO2PlaylistDAO(PlaylistCreateDTO playlistCreateDTO);

    PlaylistDAO playlistUpdateDTO2PlaylistDAO(PlaylistUpdateDTO playlistUpdateDTO);
}
