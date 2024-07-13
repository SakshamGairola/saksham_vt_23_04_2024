package com.authorize.authorize.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String extractUsername(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    Long getExpirationTime();
    String generateToken(UserDetails userDetails);

}
