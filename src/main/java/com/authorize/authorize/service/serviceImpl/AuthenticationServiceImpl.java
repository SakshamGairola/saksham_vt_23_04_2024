package com.authorize.authorize.service.serviceImpl;



import com.authorize.authorize.dto.RequestUser;
import com.authorize.authorize.dto.ResponseUser;
import com.authorize.authorize.model.User;
import com.authorize.authorize.repository.UserRepository;
import com.authorize.authorize.service.AuthenticationService;
import com.authorize.authorize.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;


//    public AuthenticationServiceImpl(
//            UserRepository userRepository,
//            AuthenticationManager authenticationManager,
//            PasswordEncoder passwordEncoder,
//            JwtService jwtService
//    ) {
//        this.authenticationManager = authenticationManager;
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.jwtService = jwtService;
//    }

    @Override
    public ResponseUser signUp(RequestUser requestUser){
        userRepository.save(
                User
                .builder()
                .fullName(requestUser.getFullName())
                .email(requestUser.getEmail())
                .password(passwordEncoder.encode(requestUser.getPassword()))
                .build()
        );

        String token = authenticateAndGenerateToken(requestUser);

        return ResponseUser
                .builder()
                .email(requestUser.getEmail())
                .jwtToken(token)
                .expiresIn(jwtService.getExpirationTime())
                .build();
    }

    @Override
    public ResponseUser signIn(RequestUser requestUser){
        String token = authenticateAndGenerateToken(requestUser);
        return ResponseUser
                .builder()
                .email(requestUser.getEmail())
                .jwtToken(token)
                .expiresIn(jwtService.getExpirationTime())
                .build();

    }

    public String authenticateAndGenerateToken(RequestUser requestUser){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestUser.getEmail(),
                        requestUser.getPassword()
                )
        );

        User authenticatedUser = userRepository.findByEmail(requestUser.getEmail()).orElseThrow();

        return jwtService.generateToken(authenticatedUser);
    }

}

