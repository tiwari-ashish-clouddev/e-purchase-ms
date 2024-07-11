package com.assembleyourpc.app.users.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "15B85F8476A1B5CBF7BA2CA0B3B2690B9BE7CB57A9D261B99439DD1363B3215E";

    public String extractUserEmail(String jwToken) {
        return extractClaim(jwToken, Claims::getSubject);
    }

    public <T> T extractClaim(String jwToken, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(jwToken);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> claims, UserDetails userDetails) {
        return Jwts
                .builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                // the token will be expired in 10 hours
                .expiration(new Date(System.currentTimeMillis() + 1000* 60 * 60 *10))
                .signWith(getSignInKey())
                .compact();
    }

    public boolean isTokenValid(String jwToken, UserDetails userDetails){
        final String userName = extractUserEmail(jwToken);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(jwToken);
    }

    private boolean isTokenExpired(String jwToken) {
        return extractExpirationDate(jwToken).before(new Date());
    }

    private Date extractExpirationDate(String jwToken) {
        return extractClaim(jwToken,Claims::getExpiration);
    }
}