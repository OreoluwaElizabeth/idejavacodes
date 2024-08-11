package com.semicolon.data.services;

import com.semicolon.data.DTO.request.AccountDeleteRequest;
import com.semicolon.data.DTO.request.UserRequest;
import com.semicolon.data.DTO.request.ViewProfileRequest;
import com.semicolon.data.DTO.response.*;
import com.semicolon.data.models.User;
import com.semicolon.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse signUp(UserRequest userRequest) {
        if (userRequest.getPassWord() == null || userRequest.getPassWord().length() < 8) {
            return new UserResponse("Invalid Password, password must be at least 8 characters");
        }
        if (userRequest.getEmail() == null) {
            return new UserResponse("Invalid email address");
        }
        List<User> existingUsers = userRepository.findByEmail(userRequest.getEmail());
        if (!existingUsers.isEmpty()) {
            return new UserResponse("Email address already in use");
        }
        User user = new User();
        user.setUsername(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassWord());
        userRepository.save(user);
        return new UserResponse("User created successfully");
    }

    @Override
    public LoginResponse login(UserRequest userRequest) {
        List<User> users = userRepository.findByEmail(userRequest.getEmail());
        if (users.isEmpty()) {
            return new LoginResponse("Email not found");
        }
        User user = users.get(0);
        if (!user.getPassword().equals(userRequest.getPassWord())) {
            return new LoginResponse("Incorrect password");
        }
        return new LoginResponse("Logged in successfully");
    }

    @Override
    public LogoutResponse logout(UserRequest userRequest) {
        return new LogoutResponse("Logged out successfully");
    }

    @Override
    public UpdateResponse updateProfile(UserRequest userRequest) {
        List<User> users = userRepository.findByEmail(userRequest.getEmail());
        if (users.isEmpty()) {
            return new UpdateResponse("User not found", null);
        }
        User user = users.get(0);
        user.setUsername(userRequest.getUserName());
        user.setPassword(userRequest.getPassWord());
        userRepository.save(user);
        return new UpdateResponse("Profile updated successfully", "");
    }

    @Override
    public ViewProfileResponse viewProfile(ViewProfileRequest viewProfileRequest) {
        User user = userRepository.findById(viewProfileRequest.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        ViewProfileResponse response = new ViewProfileResponse();
        response.setUserName(user.getUsername());
        response.setEmail(user.getEmail());
        response.setMessage("Profile viewed successfully");
        return response;
    }

    @Override
    public DeleteResponse deleteAccount(AccountDeleteRequest accountDeleteRequest) {
        List<User> users = userRepository.findByUsername(accountDeleteRequest.getUserName());
        if (users.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User user = users.get(0);
        if (!user.getPassword().equals(user.getPassword())) {
            return new DeleteResponse("Incorrect password", false);
        }
        userRepository.delete(user);
        DeleteResponse response = new DeleteResponse();
        response.setMessage("Account deleted successfully");
        response.setSuccess(true);
        return response;
    }
}
