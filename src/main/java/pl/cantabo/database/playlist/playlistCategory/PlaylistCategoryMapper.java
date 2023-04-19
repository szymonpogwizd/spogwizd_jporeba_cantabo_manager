package pl.cantabo.database.playlist.playlistCategory;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface PlaylistCategoryMapper {
    PlaylistCategoryInfoDTO playlistCategoryDAO2PlaylistCategoryDTO(PlaylistCategoryDAO playlistCategoryDAO);

    PlaylistCategoryDAO playlistCategoryCreateDTO2PlaylistCategoryDAO(PlaylistCategoryCreateDTO playlistCategoryCreateDTO);

    PlaylistCategoryDAO playlistCategoryUpdateDTO2PlaylistCategoryDAO(PlaylistCategoryUpdateDTO playlistCategoryUpdateDTO);

}
