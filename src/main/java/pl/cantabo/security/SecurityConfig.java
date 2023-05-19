package pl.cantabo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/dashboard/users/**").hasAnyAuthority("ADMINISTRATOR", "SUPER_ADMINISTRATOR")
                .requestMatchers("/dashboard/groups/**").hasAuthority("SUPER_ADMINISTRATOR")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin();

        http.userDetailsService(userDetailsService);
        return http.build();
    }
}

