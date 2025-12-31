package com.example.Users.Security;
 
// ===== Spring Core =====
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
// ===== Spring Security =====
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
// ===== Servlet =====
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 // ===== Java Utils =====
import java.io.IOException;
import java.util.List;
 // ===== Project Classes =====
import com.example.Users.Entity.User;
import com.example.Users.Respository.UserRepository;
@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;   // Utility to read & validate JWT
    @Autowired
    private UserRepository userRepository; // To fetch user & role from DB
    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,
    		FilterChain filterChain)throws ServletException, IOException {
    	String path = request.getServletPath();
        if (path.contains("/auth/login") || path.contains("/auth/register")) {
            filterChain.doFilter(request, response);
            return;
        }
     String authHeader = request.getHeader("Authorization");
      if (authHeader != null && authHeader.startsWith("Bearer ")) {
       String token = authHeader.substring(7);
       String email = jwtUtil.extractEmail(token);
      if (jwtUtil.isTokenValid(token)) {
       User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
      List<GrantedAuthority> authorities =List.of(new SimpleGrantedAuthority("ROLE_"+user.getRole().name()));
 UsernamePasswordAuthenticationToken authentication =new UsernamePasswordAuthenticationToken(email,null, 
                                authorities);
 SecurityContextHolder.getContext().setAuthentication(authentication);
 }
        }
        filterChain.doFilter(request, response);
    }
}