package pl.cantabo.database.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.cantabo.database.song.SongMapper;
import pl.cantabo.database.song.SongMapperImpl;
import pl.cantabo.database.user.UserMapper;
import pl.cantabo.database.user.UserMapperImpl;
import pl.cantabo.utils.password.PasswordEncoderMapper;

@TestConfiguration
public class MapperConfiguration {

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
    public SongMapper songMapper() {
        return new SongMapperImpl();
    }
}
