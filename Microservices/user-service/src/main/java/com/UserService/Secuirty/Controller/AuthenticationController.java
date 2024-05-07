package com.UserService.Secuirty.Controller;

import com.UserService.Secuirty.Dto.JwtAuthenticationResponse;
import com.UserService.Secuirty.Dto.RefreshTokenRequest;
import com.UserService.Secuirty.Dto.SignUpRequest;
import com.UserService.Secuirty.Dto.SigninRequest;
import com.UserService.Secuirty.Services.AuthService;
import com.UserService.model.User;
import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(value="api/v1/auth",method={RequestMethod.GET, RequestMethod.POST},produces = "application/json")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authService.SignUp(signUpRequest));
    }
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest) {
        return ResponseEntity.ok(authService.SignIn(signinRequest));
    }
    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authService.RefreshToken(refreshTokenRequest));
    }
}
