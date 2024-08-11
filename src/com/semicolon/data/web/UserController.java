package com.semicolon.data.web;

import com.semicolon.data.DTO.request.AccountDeleteRequest;
import com.semicolon.data.DTO.request.UserRequest;
import com.semicolon.data.DTO.request.ViewProfileRequest;
import com.semicolon.data.DTO.response.*;
import com.semicolon.data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public UserResponse signUp(@RequestBody UserRequest userRequest) {
        return userService.signUp(userRequest);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody UserRequest userRequest) {
        return userService.login(userRequest);
    }

    @PostMapping("/logout")
    public LogoutResponse logout(@RequestBody UserRequest userRequest) {
        return userService.logout(userRequest);
    }

    @PostMapping("/update-profile")
    public UpdateResponse updateProfile(@RequestBody UserRequest userRequest) {
        return userService.updateProfile(userRequest);
    }

    @PostMapping("/view-profile")
    public ViewProfileResponse viewProfile(@RequestBody ViewProfileRequest viewProfileRequest) {
        return userService.viewProfile(viewProfileRequest);
    }

    @PostMapping("/delete-account")
    public DeleteResponse deleteAccount(@RequestBody AccountDeleteRequest accountDeleteRequest) {
        return userService.deleteAccount(accountDeleteRequest);
    }

}
