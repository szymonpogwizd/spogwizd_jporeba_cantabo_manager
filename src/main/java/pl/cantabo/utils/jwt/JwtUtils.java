package pl.cantabo.utils.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import pl.cantabo.database.user.UserDAO;

import java.security.Key;
import java.util.Base64;

@Service
public class JwtUtils {

    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(UserDAO user) {
        String username = user.getName();

        return Jwts.builder()
                .setSubject(username)
                .signWith(secretKey)
                .compact();
    }

    public String getSecretKey() {
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }
}