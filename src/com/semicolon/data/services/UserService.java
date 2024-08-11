package com.semicolon.data.services;

import com.semicolon.data.DTO.request.AccountDeleteRequest;
import com.semicolon.data.DTO.request.UserRequest;
import com.semicolon.data.DTO.request.ViewProfileRequest;
import com.semicolon.data.DTO.request.ViewTaskRequest;
import com.semicolon.data.DTO.response.*;

public interface UserService {
    UserResponse signUp(UserRequest userRequest);
    LoginResponse login(UserRequest userRequest);
    LogoutResponse logout(UserRequest userRequest);
    UpdateResponse updateProfile(UserRequest userRequest);
    ViewProfileResponse viewProfile(ViewProfileRequest viewProfileRequest);
    DeleteResponse deleteAccount(AccountDeleteRequest AccountDeleteRequest);
}
