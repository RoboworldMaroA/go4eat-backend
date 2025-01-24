package com.managecustomers.security.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//this filter must be active, so we have to implement OnePerRequestFilter methods
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    //class inside this class that will extract a user email
    private final JwtService  jwtService;

    //import interface UserDetailService and Override this
    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        //implementation check if the user has token and is matched to the email
        //this is our request  Bearer token
        final String authHeader = request.getHeader("Authorization");
        //jwt token
        final String jwt;
        //this is verified with Jwt Service (this email is extracted from the token) and database
        final  String userEmail;

        // if header is null or not start with Bearer - it must start with Bearer , then go to next filter
        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
         //we want to extract jwd token and this token is after a "Bearer " so after 7 place,
             // so we use substring to get this value
             jwt = authHeader.substring(7);
          //to check if the user is in database, JWT Service extract used data and compare with this what is on the server
            // to get a user email from JWT we have to create class which has ability to extract that
             userEmail = jwtService.extractUsername(jwt);
             //this part is implemented after implementation JwtService
        //if user email is not null, and he is not authenticated then check if there is a userin database
            if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
                //Do this after creating ApplicationConfig class
                //if token is valid then go to next step
                if(jwtService.isTokenValid(jwt, userDetails)){
                    //need this to update security context
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
                    authToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                    );

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
            filterChain.doFilter(request,response);
        }
    }

