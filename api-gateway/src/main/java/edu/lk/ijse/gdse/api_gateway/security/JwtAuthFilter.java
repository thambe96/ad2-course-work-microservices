package edu.lk.ijse.gdse.api_gateway.security;

import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        String path = exchange.getRequest().getURI().getPath();

        if (path.startsWith("/auth/")) {
            return chain.filter(exchange);
        }

        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return unauthorized(exchange);
        }

        String token = authHeader.substring(7);
        if (!isValid(token)) {
            return unauthorized(exchange);
        }

        // allow request
        return chain.filter(exchange);
    }


    private boolean isValid(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey("bcd5bcc8555ca7d9f7cf971aecd33dc631a3b61bef110dcc2ba3634d4aaaf93d".getBytes())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Mono<Void> unauthorized(ServerWebExchange exchange) {
        exchange.getResponse().setRawStatusCode(HttpStatus.UNAUTHORIZED.value());
        return exchange.getResponse().setComplete();
    }



}
