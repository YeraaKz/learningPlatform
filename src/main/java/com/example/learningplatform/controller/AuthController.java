package com.example.learningplatform.controller;

import com.example.learningplatform.model.request.AuthenticationRequest;
import com.example.learningplatform.model.request.RegisterRequest;
import com.example.learningplatform.model.response.AuthenticationResponse;
import com.example.learningplatform.security.service.AuthService;
import com.example.learningplatform.security.service.TokenBlacklistService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final Logger log = LoggerFactory.getLogger(AuthController.class);

    private final AuthService service;
    private final TokenBlacklistService tokenBlacklistService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/logout")
    public void logout(@RequestHeader("Authorization")String token){
        String jwt = token.substring("Bearer ".length());
        tokenBlacklistService.addToBlacklist(jwt);
        log.debug("User logout");
    }
}
