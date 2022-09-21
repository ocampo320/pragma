package com.pragma.pragma.security.jwt;

import com.pragma.pragma.models.UserDb;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    private int profession;

    public String generateToken(Authentication authentication) {
        UserDb clientPrincipal = (UserDb) authentication.getPrincipal();

        return Jwts.builder()
                .claim("id", clientPrincipal.getId())

                .claim("profession", profession)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }





//    public String generateTokenEmail(Authentication authentication) {
//        ClientPrincipal clientPrincipal = (ClientPrincipal) authentication.getPrincipal();
//        return Jwts.builder()
//                .claim("id", clientPrincipal.getId())
//                .claim("rol", clientPrincipal.getRoles().getId())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }

    public String getNombreUsuarioFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("token mal formado");
        } catch (UnsupportedJwtException e) {
            logger.error("token no soportado");
        } catch (ExpiredJwtException e) {
            logger.error("token expirado");
        } catch (IllegalArgumentException e) {
            logger.error("token vacío");
        } catch (SignatureException e) {
            logger.error("fail en la firma");
        }
        return false;
    }
}
