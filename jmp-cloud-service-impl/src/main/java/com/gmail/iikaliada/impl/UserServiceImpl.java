package com.gmail.iikaliada.impl;

import com.gmail.iikaliada.converter.UserConverter;
import com.gmail.iikaliada.dto.UserRequestDto;
import com.gmail.iikaliada.dto.UserResponseDto;
import com.gmail.iikaliada.entity.User;
import com.gmail.iikaliada.repository.UserRepository;
import com.gmail.iikaliada.serivce.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String USER_NOT_FOUND_ERROR = "User with id = %d is not found";

    private final UserConverter userConverter;

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto requestDto) {
        User user = userConverter.convertUserDtoToUser(requestDto);
        return userConverter.convertUserToUserDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto requestDto) {
        return userConverter.convertUserToUserDto(userRepository.save(userConverter.convertUserDtoToUser(requestDto)));
    }

    @Override
    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchElementException(String.format(USER_NOT_FOUND_ERROR, id));
        }
    }

    @Override
    public UserResponseDto getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return userConverter.convertUserToUserDto(user.get());
        } else
            throw new NoSuchElementException(String.format(USER_NOT_FOUND_ERROR, id));
    }

    @Override
    public List<UserResponseDto> getAllUser() {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        userRepository.findAll().forEach(user -> userResponseDtos.add(userConverter.convertUserToUserDto(user)));
        return userResponseDtos;
    }

}
