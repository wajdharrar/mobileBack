package com.bri.mobile.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private final static String SECRET_KEY="mpL9yztXZNQJgLVfyWIDp3ZOP7yULoCn9i0tJXSf3dtGK/WJ90KJ6H9gNoD7z3q3edIJWQZVJGnBmdlyVEoDdUG6iAJXOzTXTgH68MaVUHnoZZKnY2C/61xbDJZ5uAptncig/qpx6wIvvZLyXFD4Gz7RRhY27iuwigOYpq4hWgZOcPSNz7lyRa/d7RLTFYhuvwKliuU05rJ3xTQBCxoEGQdO1xmRLLHS3RhtCx2cnZwHNbOot7rXqbBsoUEhZRFzIGzQCHmL6PPWgL2LP4gKFb9sob3ZFLa6hbmQJP6u9S2qp+JapkwpexTGzuvHBj8Iw9HAT9VoPBN2KdHlAg3NDdBXJX2V3OmfBOfYndHE06w";
    public String extractUsername(String token){
        return extractClaim(token,Claims ::getSubject);
    }
    public <T> T extractClaim(String token, Function<Claims,T>claimResolver){
        final Claims claims =extractAllClaims(token);
        return claimResolver.apply(claims);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getPublicSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getPublicSigningKey() {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public String generateToken(Map<String,Object> extraClaims, UserDetails userDetails){
        return Jwts.builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getPublicSigningKey(),Jwts.SIG.HS512)
                .compact();
    }
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }
    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && ! isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExperation(token).before(new Date());
    }

    private Date extractExperation(String token) {
        return extractClaim(token,Claims::getExpiration);
    }
}
