package com.estudo.java.spring.CompaninVTR.Infra;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.estudo.java.spring.CompaninVTR.Model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TokenService {
    @Value("${api.security.token.secret}")
    private String SECRET;
    Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);

    public String generetedToken(User user){
        try{
            String token = JWT.create()
                    .withIssuer("faculdade-api")
                    .withSubject(user.getLogin())
                    .withClaim("type", user.getClass().getSimpleName())
                    .withExpiresAt(getExpiretion())
                    .sign(ALGORITHM);

            return token;
        } catch (Exception e) {
            throw new RuntimeException("Erro em criar o token do usuário: " + getClass().toString() + e);
        }
    }

    public String validateToken(String token){
        try {
            return JWT.require(ALGORITHM)
                    .withIssuer("faculdade-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private Instant getExpiretion(){ return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));

    }
}
