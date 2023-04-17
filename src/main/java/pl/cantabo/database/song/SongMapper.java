package pl.cantabo.database.song;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SongMapper {

    SongInfoDTO songDAO2SongInfoDTO(SongDAO songDAO);

    SongDAO songCreateDTO2SongDAO(SongCreateDTO songCreateDTO);

    SongDAO songUpdateDTO2SongDAO(SongUpdateDTO songUpdateDTO);
}
