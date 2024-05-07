package com.UserService.Secuirty.Services;

import com.UserService.Secuirty.Dto.JwtAuthenticationResponse;
import com.UserService.Secuirty.Dto.RefreshTokenRequest;
import com.UserService.Secuirty.Dto.SignUpRequest;
import com.UserService.Secuirty.Dto.SigninRequest;
import com.UserService.model.User;


public interface AuthService {
    User SignUp(SignUpRequest signUpRequest) ;
    JwtAuthenticationResponse SignIn(SigninRequest signinRequest) ;
    JwtAuthenticationResponse RefreshToken (RefreshTokenRequest refreshTokenRequest) ;
}
