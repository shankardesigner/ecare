package com.shankardesigner.ecare.config;

import com.shankardesigner.ecare.model.User;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.shankardesigner.ecare.config.SecurityConstants.EXPIRATION_TIME;
import static com.shankardesigner.ecare.config.SecurityConstants.SECRET_KEY;

@Component
public class JwtTokenProvider {

    //Generate the token
    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());

        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        String userId = user.getUserId().toString();
        //user.getRoles().forEach(roles -> roles.getRoleName());

        Map<String, Object> claims = new HashMap<>();
        claims.put("id",userId);
        claims.put("username",user.getUsername());
        claims.put("fullName", user.getFullName());
        claims.put("role", user.getRoles().get(0).getRoleName());

        return Jwts.builder()
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .compact();
    }
    //validate the token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        }catch (SignatureException ex) {
            System.out.println("Invalid JWT Signature");
        }catch (MalformedJwtException ex) {
            System.out.println("Invalid JWT Token");
        }catch (ExpiredJwtException ex) {
            System.out.println("Expired JWT Token");
        }catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported jwt exception");
        }catch (IllegalArgumentException ex) {
            System.out.println("JWT claims String is empty");
        }
        return false;
    };

    //user id from the token
    public UUID getUserIdFromJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        String id = (String) claims.get("id");
        return UUID.fromString(id);
    };
}
