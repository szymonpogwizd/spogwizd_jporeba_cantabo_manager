package pl.cantabo.database.settings.factory;

import pl.cantabo.database.settings.SettingsDAO;

import java.util.UUID;

public class SettingsDAOFactory {

    public static final Boolean DARK_THEME = false;

    public static final float FONT_SIZE = 12;


    public static SettingsDAO.SettingsDAOBuilder defaultBuilder(){
        return SettingsDAO.builder()
                .darkTheme(DARK_THEME)
                .fontSize(FONT_SIZE)
                .id(UUID.randomUUID());
    }

    public static SettingsDAO defaultSettings() {return SettingsDAO.builder().build();}


}