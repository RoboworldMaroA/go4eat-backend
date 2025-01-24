package com.managecustomers.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/","/api/v1/customer","/api/v1/auth/**",("/displayUsers"),
                        ("/displayUsers/**"), ("/api/v1/trip"),("/api/v1/trip/**"),("/api/jwt/trip/**"),
                        ("/api/v1/form/**"),
                        ("/registerUserAndForm"),
                        ("/api/v1/email"),("/api/v1/email/**"),("/api/jwt/email/**")

                        ).permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        ;
        return http.build();
    }


      @Bean
      CorsConfigurationSource corsConfigurationSource(){
          CorsConfiguration configuration = new CorsConfiguration();

          String allowsOrigin = "http://127.0.0.1:5501";
          String allowsOrigin2 = "https://manage-customers-4x6n9.ondigitalocean.app";
          String allowsOrigin3 = "https://localhost:3000";
          String allowsOrigin4 = "http://localhost:3000";
          String allowsOrigin5 = "http://127.0.0.1:5502";
          String allowsOriginOnLocalHostHttps = "https://127.0.0.1:5502";
          String allowsOriginForSmartLuggageFrontend = "https://smartluggage-ijzs3.ondigitalocean.app";
          String allowsOriginForSmartLuggageFrontendGoogleCloud = "https://smartluggage2023.ew.r.appspot.com";
          String allowsOriginLocalHost = "http://127.0.0.1:5500";
          String allowsOriginGo4EatDevelopment = "https://go4eat-mih6g.ondigitalocean.app";
          String allowsOriginGo4EatDeployed = "https://go4eat.eu";
          configuration.setAllowedOrigins(List.of(allowsOrigin,allowsOrigin2,allowsOrigin3,allowsOrigin4,allowsOrigin5, allowsOriginOnLocalHostHttps,
                  allowsOriginForSmartLuggageFrontend,allowsOriginForSmartLuggageFrontendGoogleCloud,
                  allowsOriginLocalHost, allowsOriginGo4EatDevelopment, allowsOriginGo4EatDeployed));
          configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT", "HEAD", "OPTIONS","DELETE"));
          configuration.setAllowedHeaders(Arrays.asList("Authorization","Content-Type","accept", "accept-language", "content-type",  "authorization", "moduleid", "tabid", "x-dnn-moniker"));

          UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
          source.registerCorsConfiguration("/**",configuration);
          return source;
      }



}
