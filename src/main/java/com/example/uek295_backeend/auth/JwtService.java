package com.example.uek295_backeend.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * This service provides functionalities related to JWT (JSON Web Token).
 * It offers methods to create a JWT and to retrieve the username from a JWT.
 */
@Service
public class JwtService {

    // Secret key for JWT signing and verification. This should be kept secure and private in a real-world application.
    private final String secret = "secret";

    /**
     * Creates a JWT for a given username.
     *
     * @param userName The username for which the JWT should be created.
     * @return A JWT string.
     */
    public String createJwt(String userName) {
        return Jwts
                .builder()
                .setIssuer("admin")  // The issuer of the JWT
                .setIssuedAt(new Date(System.currentTimeMillis()))  // The date/time when the JWT is issued
                .setExpiration(new Date(System.currentTimeMillis() * 60 * 60 * 24 * 20))  // The expiration date/time of the JWT
                .setSubject(userName)  // The subject of the JWT (the username in this case)
                .signWith(SignatureAlgorithm.HS256, secret)  // Signing the JWT using HS256 algorithm and the secret key
                .compact();
    }

    /**
     * Retrieves the username from a given JWT.
     *
     * @param jwt The JWT from which the username should be extracted.
     * @return The username from the JWT.
     */
    public String getUserName(String jwt) {
        return Jwts
                .parser()
                .setSigningKey(secret)  // Set the signing key for JWT verification
                .parseClaimsJws(jwt)  // Parse the JWT claims
                .getBody()  // Get the JWT body
                .getSubject();  // Get the subject (username) from the JWT body
    }
}
