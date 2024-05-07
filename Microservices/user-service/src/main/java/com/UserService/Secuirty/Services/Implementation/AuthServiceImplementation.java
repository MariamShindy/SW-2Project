package com.UserService.Secuirty.Services.Implementation;




import com.UserService.Secuirty.Dto.JwtAuthenticationResponse;
import com.UserService.Secuirty.Dto.RefreshTokenRequest;
import com.UserService.Secuirty.Dto.SignUpRequest;
import com.UserService.Secuirty.Dto.SigninRequest;
import com.UserService.Secuirty.Services.AuthService;
import com.UserService.Secuirty.Services.JWTService;
import com.UserService.model.Role;
import com.UserService.model.User;
import com.UserService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class AuthServiceImplementation implements AuthService {
@Autowired
    private UserRepository userRepository;
@Autowired
    private PasswordEncoder passwordEncoder;
@Autowired
private AuthenticationManager authenticationManager;
@Autowired
private JWTService jwtService;

    private static final Logger logger = Logger.getLogger(AuthServiceImplementation.class.getName());

   public User SignUp(SignUpRequest signUpRequest){
       logger.info("Starting sign up process");
    User user = new User();
    user.setEmail(signUpRequest.getEmail());
    user.setFristName(signUpRequest.getFirstname());
    user.setLastName(signUpRequest.getLastname());
    user.setRole(Role.Customer);
    user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
    logger.info("Signing up user : " + user.getFristName() + user.getLastName());
     return  userRepository.save(user);
}
public JwtAuthenticationResponse SignIn(SigninRequest signinRequest){
    logger.info("Starting sign in process");
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(),signinRequest.getPassword()));
    var user = userRepository.findByEmail(signinRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
    var jwt = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(new HashMap<>() , user);
    JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
    jwtAuthenticationResponse.setToken(jwt);
    jwtAuthenticationResponse.setRefreshToken(refreshToken);
    logger.info("Signing in user with email : " + user.getEmail());
    return jwtAuthenticationResponse;
}
public JwtAuthenticationResponse RefreshToken (RefreshTokenRequest refreshTokenRequest){
    String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
    User user = userRepository.findByEmail(userEmail).orElseThrow();
    if (jwtService.isTokenValid(refreshTokenRequest.getToken(),user))
    {
        var jwt = jwtService.generateToken(user);
        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
        return jwtAuthenticationResponse;
    }
    return null;
}

}
