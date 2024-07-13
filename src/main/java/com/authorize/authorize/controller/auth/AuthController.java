package com.authorize.authorize.controller.auth;

import com.authorize.authorize.dto.RequestUser;
import com.authorize.authorize.dto.ResponseUser;
import com.authorize.authorize.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping ("auth")
@RestController
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("signup")
    public ResponseEntity<ResponseUser> signup(@RequestBody RequestUser requestUser){
        ResponseUser responseUser = authenticationService.signUp(requestUser);
        return ResponseEntity.ok(responseUser);
    }

    @PostMapping("login")
    public ResponseEntity<ResponseUser> signIn(@RequestBody RequestUser requestUser){
        ResponseUser responseUser = authenticationService.signIn(requestUser);
        return ResponseEntity.ok(responseUser);
    }

}
