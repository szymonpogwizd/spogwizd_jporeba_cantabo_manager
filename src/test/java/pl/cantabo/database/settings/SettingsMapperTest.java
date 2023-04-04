package pl.cantabo.database.settings;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.cantabo.database.settings.factory.SettingsDAOFactory;
import pl.cantabo.database.user.UserMapper;
import pl.cantabo.database.user.UserMapperImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestConfiguration
@ExtendWith(SpringExtension.class)
class SettingsMapperTest {

    @Autowired
    private SettingsMapper settingsMapper;

    @Bean
    public SettingsMapper settingsMapper() {
        return new SettingsMapperImpl();
    }

    @Test
    void settingsDAO2SettingsDTO() {
        //Given
        SettingsDAO settingsDAO = SettingsDAOFactory.defaultBuilder().build();
        // when

        SettingsInfoDTO settingsInfoDTO = settingsMapper.settingsDA2SettingsDTO(settingsDAO);
        // then
        assertNotNull(settingsInfoDTO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(settingsDAO.isDarkTheme()).isEqualTo(settingsInfoDTO.isDarkTheme());
        softly.assertThat(settingsDAO.getFontSize()).isEqualTo(settingsInfoDTO.getFontSize());
        softly.assertAll();
    }

    @Test
    void settingsCreateDAO2SettingsDTO() {
    }

    @Test
    void settingsUpdateDAO2SettingsDTO() {
    }
}