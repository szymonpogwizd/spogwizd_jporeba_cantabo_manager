package pl.cantabo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pl.cantabo.configuration.PasswordEncoderConfig;
import pl.cantabo.utils.jwt.JwtAuthenticationFilter;
import pl.cantabo.utils.jwt.JwtLoginFilter;
import pl.cantabo.utils.jwt.JwtUtils;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtUtils jwtUtils;
    private final UserDetailsServiceImpl userDetailsService;
    @Autowired
    private PasswordEncoderConfig passwordEncoderConfig;

    public SecurityConfig(JwtUtils jwtUtils, UserDetailsServiceImpl userDetailsService) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoderConfig.passwordEncoder());
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManagerBean();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/dashboard/users/**").hasAnyAuthority("ADMINISTRATOR", "SUPER_ADMINISTRATOR")
                .requestMatchers("/dashboard/groups/**").hasAuthority("SUPER_ADMINISTRATOR")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin()
                .and()
                .addFilterBefore(new JwtLoginFilter("/login", authenticationManagerBean(), jwtUtils), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtAuthenticationFilter(authenticationManagerBean(), jwtUtils), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return new ProviderManager(Arrays.asList(authenticationProvider()));
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoderConfig.passwordEncoder());
        return provider;
    }
}
