package com.stackroute.authenticationservice.config;

import com.stackroute.authenticationservice.model.User;

import java.util.Map;

public interface JwtTokenGenerator {
    Map<String,String> generateToken(User user);
}
