package com.example.impermanenceservice.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "impermanence_63"; //密钥
    private static final long EXPIRATION_TIME = 86400000; // 过期时间（毫秒）


    /**
     * 生成 JWT
     *
     * @param claims 载荷
     * @return JWT
     */
    public String generateToken(Map<String, Object> claims) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(nowMillis + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY);
        return builder.compact();
    }

    /**
     * 解析 JWT
     *
     * @param token JWT
     * @return 载荷
     */
    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            // token签名不正确
            return false;
        }
    }

    public static Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}
