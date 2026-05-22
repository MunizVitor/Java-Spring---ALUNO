package com.estudo.java.spring.CompaninVTR.Infra;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.estudo.java.spring.CompaninVTR.Model.Users.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);//criacao do tipo de algoritimo que iremos usar para criar
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getLogin())
                    .withExpiresAt(getExpriretions())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException e){
            throw  new RuntimeException("Erro while genetated token", e);
        }
    }

    public String validadeToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();//pega o login do usuario que esta usando, o retorno dele e o login verificado realmente
        }catch (JWTCreationException e){
            return "";//aqui vai retornar esta string vazia para que no metodo que chamar este vai ter a resposta que o usuario que esta tentando entrar nao vai estar autorizado a entrar
        }
    }

    private Instant getExpriretions(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
        //aqui pegou 2 horas que será o tempo de duração do token e colocou na variavel Instant e nosso timeZone/ZoneOffset que e o Brasil
    }
}
