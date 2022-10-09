package com.example.mycoffee.controller;

import com.example.mycoffee.mapping.requests.AuthRequest;
import com.example.mycoffee.mapping.requests.RegistrationRequest;
import com.example.mycoffee.mapping.responses.AccountResponse;
import com.example.mycoffee.service.AccountService;
import com.example.mycoffee.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private  TokenService tokenService;

    @PostMapping("/token")
    public ResponseEntity token(Authentication authentication) {
        return ResponseEntity.ok().body(tokenService.generateToken(authentication));
    }

    @GetMapping("/test")
    public ResponseEntity getDataTest(Principal principal) {
        return ResponseEntity.ok().body(principal.getName());
    }

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody RegistrationRequest account) {
        try {
            accountService.registration(account);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestBody AuthRequest authRequest) {
        try {
            AccountResponse account = accountService.login(authRequest);
            return ResponseEntity.ok().body(account);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
