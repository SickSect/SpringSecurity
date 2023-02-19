package com.xecurity.security_amo.config;

import com.xecurity.security_amo.service.JwtServ;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/*
this is first step in security
request go through this filter,
so we need extends OncePerRequestFilter
bc every request should go through here
*/
@Component
@RequiredArgsConstructor
public class JwtAuthFilter  extends OncePerRequestFilter {
    private final JwtServ jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain  //it contains the other filters that we need to execute. Through this param we call next filter in out chain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwtToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }
        jwtToken = authHeader.substring(7, authHeader.length()); // extracting out TOKEN
        userEmail = jwtService.extractingEmail(jwtToken); //extracting email from jwt\// through SecurityContextHolder
        // We can check if user already authenticated
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){ // if we have an email and our user is not authenticated
            UserDetails userDetails =  this.userDetailsService.loadUserByUsername(userEmail); // get userDetails from DB
            if (jwtService.isTokenValid(jwtToken, userDetails)){ // if user and token is valid
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken( // create object of this type
                        userDetails, null,
                        userDetails.getAuthorities()); // get our authToken
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // set details from request
                // now we need to update SecurityContextHolder with our new authToken
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
            filterChain.doFilter(request, response); // continue our filter chain
        }
    }
}
