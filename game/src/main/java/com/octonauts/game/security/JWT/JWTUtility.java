
package com.octonauts.game.security.JWT;


import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static java.util.Collections.emptyList;

public class JWTUtility {

    public static String generateToken(String username) {
        String jwtToken = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
                .compact();
        return jwtToken;
    }

    public static String parseToken(String jwtToken) {
        if (jwtToken == null || jwtToken.isEmpty()) return null;
        try {
            String username = Jwts.parser()
                    .setSigningKey(SecurityConstants.SECRET)
                    .parseClaimsJws(jwtToken)
                    .getBody()
                    .getSubject();
            return username;
        } catch (JwtException e) {
            return null;
        }
    }

    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(SecurityConstants.HEADER_STRING);

        if (token == null || token.isEmpty() || !token.startsWith(SecurityConstants.TOKEN_PREFIX)) return null;
        String username = parseToken(token.replace(SecurityConstants.TOKEN_PREFIX, ""));

        return username != null ? new UsernamePasswordAuthenticationToken(username, null, emptyList()) : null;
    }

}