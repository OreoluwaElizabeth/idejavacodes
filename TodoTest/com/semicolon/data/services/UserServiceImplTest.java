package com.semicolon.data.services;

import com.semicolon.data.DTO.request.AccountDeleteRequest;
import com.semicolon.data.DTO.request.UserRequest;
import com.semicolon.data.DTO.request.ViewProfileRequest;
import com.semicolon.data.DTO.response.*;
import com.semicolon.data.models.User;
import com.semicolon.data.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void signUp() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName("Lizzy");
        userRequest.setEmail("Timothy@gmail.com");
        userRequest.setPassWord("Password");
        UserResponse userResponse = userService.signUp(userRequest);
        assertThat(userResponse).isNotNull();
        assertThat(userResponse.getMessage()).isEqualTo("User created successfully");

    }

    @Test
    public void signUpWithInvalidPassword() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName("Lizzy");
        userRequest.setEmail("Timothy@gmail.com");
        userRequest.setPassWord("short");
        UserResponse userResponse = userService.signUp(userRequest);
        assertThat(userResponse).isNotNull();
        assertThat(userResponse.getMessage()).isEqualTo("Invalid Password, password must be at least 8 characters");
    }

    @Test
    public void signUpWithNullEmail() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName("Lizzy");
        userRequest.setEmail(null);
        userRequest.setPassWord("Password");
        UserResponse userResponse = userService.signUp(userRequest);
        assertThat(userResponse).isNotNull();
        assertThat(userResponse.getMessage()).isEqualTo("Invalid email address");
    }

    @Test
    public void testLogin() {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("timothy@gmail.com");
        userRequest.setPassWord("12345678");
        userService.signUp(userRequest);

        UserRequest loginRequest = new UserRequest();
        loginRequest.setEmail("timothy@gmail.com");
        loginRequest.setPassWord("12345678");
        LoginResponse loginResponse = userService.login(loginRequest);
        assertThat(loginResponse).isNotNull();
        assertThat(loginResponse.getMessage()).isEqualTo("Logged in successfully");
    }

    @Test
    public void testLogout() {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("lizzy@gmail.com");
        LogoutResponse logoutResponse = userService.logout(userRequest);
        assertNotNull(logoutResponse);
        assertEquals("Logged out successfully", logoutResponse.getMessage());
    }

    @Test
    public void testUpdate() {
        UserRequest createUserRequest = new UserRequest();
        createUserRequest.setEmail("lizzy@gmail.com");
        createUserRequest.setPassWord("password");
        userService.signUp(createUserRequest);

        UserRequest loginRequest = new UserRequest();
        loginRequest.setEmail("lizzy@gmail.com");
        loginRequest.setPassWord("password");
        LoginResponse loginResponse = userService.login(loginRequest);
        assertNotNull(loginResponse);

        UserRequest updateRequest = new UserRequest();
        updateRequest.setEmail("lizzy@gmail.com");
        updateRequest.setUserName("lizzy");
        updateRequest.setPassWord("12345678");
        UpdateResponse updateResponse = userService.updateProfile(updateRequest);
        assertNotNull(updateResponse);
        assertEquals("Profile updated successfully", updateResponse.getMessage());
    }

    @Test
    public void testViewProfile() {
        User user = new User();
        user.setId("12");
        user.setUsername("Lizzy");
        user.setEmail("rosh@gmail.com");
        userRepository.save(user);

        ViewProfileRequest request = new ViewProfileRequest();
        request.setId("12");

        ViewProfileResponse response = userService.viewProfile(request);
        assertEquals("Lizzy", response.getUserName());
        assertEquals("rosh@gmail.com", response.getEmail());
        assertEquals("Profile viewed successfully", response.getMessage());
    }

    @Test
    public void testDeleteAccount() {
        User user = new User();
        user.setUsername("Elizabeth");
        user.setPassword("12345678");
        userRepository.save(user);

        AccountDeleteRequest request = new AccountDeleteRequest();
        request.setUserName("Elizabeth");
        request.setPassword("12345678");

        DeleteResponse response = userService.deleteAccount(request);
        assertEquals("Account deleted successfully", response.getMessage());
        assertTrue(response.getSuccess());

        List<User> users = userRepository.findByUsername("Elizabeth");
        assertEquals(0, users.size());
    }
}
