package com.authorize.authorize.service;

import com.authorize.authorize.dto.RequestUser;
import com.authorize.authorize.dto.ResponseUser;

public interface AuthenticationService {

    ResponseUser signUp(RequestUser requestUser);
    ResponseUser signIn(RequestUser requestUser);

}
