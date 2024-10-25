package com.example.atividade01.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.atividade01.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class JwtUtils {

    @Value("${api.security.token.secret}")
    private String secret;


    private final long EXPIRATION_TIME = 1; // 1hr (ajustado para usar horas e não milissegundos)

    // Gera o token JWT com claims personalizados
    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getUsername())
                    .withClaim("id", user.getId())
                    .withClaim("name", user.getUsername())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            System.out.println("Erro ao gerar o token JWT: " + exception.getMessage()); // Log da exceção
            throw new RuntimeException("Erro ao gerar o token JWT", exception);
        }
    }

    // Valida o token e retorna o username (subject)
    public String getUsernameFromToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT jwt = JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token);
            return jwt.getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado", exception);
        }
    }

    // Gera a data de expiração do token
    private Instant genExpirationDate() {
        return LocalDateTime.now().plusHours(EXPIRATION_TIME).toInstant(ZoneOffset.of("-03:00"));
    }
}
