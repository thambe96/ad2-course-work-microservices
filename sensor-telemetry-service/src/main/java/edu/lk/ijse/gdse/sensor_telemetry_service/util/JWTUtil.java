package edu.lk.ijse.gdse.sensor_telemetry_service.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt.secret}")
    private String jwtSecret;

    private final Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    public boolean isTokenExpired(String token) {
        try {
            return getClaims(token)
                    .getExpiration()
                    .before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

}
