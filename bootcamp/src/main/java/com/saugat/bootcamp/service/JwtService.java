//package com.saugat.bootcamp.service;
//
//import com.saugat.bootcamp.dto.UserDto;
//import com.saugat.bootcamp.exceptions.ResourceNotFoundException;
//import com.saugat.bootcamp.model.User;
//import com.saugat.bootcamp.repository.UserRepository;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.stereotype.Service;
//
//import java.nio.charset.StandardCharsets;
//import java.security.Key;
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class JwtService {
//    private static final String SECRET = "CHANGE_ME_TO_A_LONG_RANDOM_SECRET_AT_LEAST_32_CHARS_LONG_123456";
//    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());
//    private final UserRepository userRepository;
//
//    public JwtService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public String generateToken(UserDto user){
//       User existingUser =  userRepository.findUserByEmail(user.getEmail());
//
//       List<String> roles = new ArrayList<>();
//       if(user.getEmail().equals("saugat@gmail.com")){
//           roles = List.of("ADMIN");
//       }else{
//           roles = List.of("CUSTOMER");
//       }
//
//        return Jwts.builder()
//                .setSubject(user.getEmail())
//                .claim("roles", roles)
//                .issuer("www.saugatthapachhetri.com.np")
//                .audience().add("Saugat").and()
//                .setIssuedAt(Date.from(Instant.now()))
//                .setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.DAYS)))
//                .signWith(KEY)
//                .compact();
//    }
//}
