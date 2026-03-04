//package com.saugat.bootcamp.utils;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//
//import javax.crypto.SecretKey;
//import java.nio.charset.StandardCharsets;
//import java.security.Key;
//import java.util.List;
//
//public class JwtUtils {
//    private static final String SECRET = "CHANGE_ME_TO_A_LONG_RANDOM_SECRET_AT_LEAST_32_CHARS_LONG_123456";
//    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());
//
//    public static String extractSubject(String token) {
//        try{
//            Claims claims = Jwts.parser()
//                    .verifyWith((SecretKey) KEY)
//                    .build()
//                    .parseSignedClaims(token)
//                    .getPayload();
//            return claims.getSubject();
//        }catch(Exception e){
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//
//    public static List<String> extractRole(String token){
//        try{
//            Claims claims = Jwts.parser()
//                    .verifyWith((SecretKey) KEY)
//                    .build()
//                    .parseSignedClaims(token)
//                    .getPayload();
//            return (List<String>)claims.get("roles");
//        }catch(Exception e){
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//}
