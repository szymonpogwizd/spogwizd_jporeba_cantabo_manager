package pl.cantabo.database.settings;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.cantabo.utils.password.EncodedMapping;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)

public interface SettingsMapper {
    SettingsInfoDTO settingsDA2SettingsDTO(SettingsDAO settingsDAO);


    SettingsDAO settingsCreateDAO2SettingsDTO(SettingsCreateDTO settingsCreateDTO);

    SettingsDAO settingsUpdateDAO2SettingsDTO(SettingsUpdateDTO settingsUpdateDTO);


}