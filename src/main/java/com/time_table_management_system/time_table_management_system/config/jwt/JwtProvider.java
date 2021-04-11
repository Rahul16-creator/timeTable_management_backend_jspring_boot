package com.time_table_management_system.time_table_management_system.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtProvider {


    @Autowired
    private UserDetailsService userDetailsService;


    @Value("${jwt.secret.key}")
    private String SecretKey;

    @PostConstruct
    public void init() {
        SecretKey = Base64.getEncoder().encodeToString(SecretKey.getBytes());
    }

    private long validityInMilliseconds = 1000 * 60 * 60 * 60;

    public String createToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);

        Date now = new Date();
        return Jwts.builder().setClaims(claims).setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + validityInMilliseconds))
                .signWith(SignatureAlgorithm.HS256, SecretKey).compact();
    }


    public Authentication getAuthentication(String token) {
        String username = Jwts.parser().setSigningKey(SecretKey).parseClaimsJws(token).getBody().getSubject();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public boolean validateToken(String token) {
        Jwts.parser().setSigningKey(SecretKey).parseClaimsJws(token).getBody();
        return true;
    }
}
