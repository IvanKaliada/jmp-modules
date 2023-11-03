package com.gmail.iikaliada.controller;

import com.gmail.iikaliada.dto.UserRequestDto;
import com.gmail.iikaliada.dto.UserResponseDto;
import com.gmail.iikaliada.serivce.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequestMapping("/api/userGroup")
@RestController
@RequiredArgsConstructor
public class UserController implements UserApi{

    private final UserService userService;

    @PostMapping(value = "/users")
    public UserResponseDto createUser(@RequestBody UserRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    @PutMapping(value = "/users/update")
    public UserResponseDto updateUser(@RequestBody UserRequestDto requestDto) {
        return userService.updateUser(requestDto);
    }

    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @GetMapping(value = "/users/{id}")
    public UserResponseDto getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @GetMapping(value = "/users")
    public List<UserResponseDto> getAllUser() {
        return userService.getAllUser();
    }

    @ExceptionHandler(value
            = {NoSuchElementException.class})
    public ResponseEntity<Object> handleUserNotFound(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                ex.getMessage(), new HttpHeaders(), NOT_FOUND);
    }

}
