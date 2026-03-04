//package com.saugat.bootcamp.controller;
//
//import com.saugat.bootcamp.utils.JwtUtils;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.List;
//
//public class JwtTokenValidatorFilter extends OncePerRequestFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String authHeader = request.getHeader("Authorization");
//        if(authHeader != null && authHeader.startsWith("Bearer ")){
//            System.out.println("Auth Token: "+ authHeader);
//
//            String subjectName = JwtUtils.extractSubject(authHeader.substring(7));
//            List<String> roles = JwtUtils.extractRole(authHeader.substring(7));
//            System.out.println(subjectName + "\n" + roles);
//
//            List<SimpleGrantedAuthority> authorities=roles.stream().map(role->new SimpleGrantedAuthority(role)).toList();
//
//            UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(subjectName,null,authorities);
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//
//        }
//        filterChain.doFilter(request, response);
//
//    }
//}
