package com.microsservicos.auth.controller;

import org.springframework.web.bind.annotation.;
import java.util.;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        Map<String, String> response = new HashMap<>();

        if ("admin".equals(username) && "123".equals(password)) {
            response.put("token", "token-" + UUID.randomUUID().toString());
            response.put("status", "success");
        } else {
            response.put("status", "error");
            response.put("message", "Credenciais inválidas");
        }

        return response;
    }

    @GetMapping("/validate")
    public Map<String, String> validate(@RequestParam String token) {
        Map<String, String> response = new HashMap<>();

        if (token != null && token.startsWith("token-")) {
            response.put("valid", "true");
        } else {
            response.put("valid", "false");
        }

        return response;
    }
}
