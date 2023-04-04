package pl.cantabo.database.user;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.cantabo.database.settings.SettingsMapper;
import pl.cantabo.database.settings.SettingsMapperImpl;
import pl.cantabo.utils.password.PasswordEncoderMapper;

@TestConfiguration
public class RealMapper {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PasswordEncoderMapper passwordEncoderMapper(PasswordEncoder passwordEncoder) {
        return new PasswordEncoderMapper(passwordEncoder);
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public SettingsMapper settignsMapper() {
        return new SettingsMapperImpl();
    }
}
