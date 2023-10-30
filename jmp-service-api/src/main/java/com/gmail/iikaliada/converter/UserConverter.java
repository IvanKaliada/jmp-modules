package com.gmail.iikaliada.converter;

import com.gmail.iikaliada.dto.UserRequestDto;
import com.gmail.iikaliada.dto.UserResponseDto;
import com.gmail.iikaliada.entity.User;

public interface UserConverter {

    UserResponseDto convertUserToUserDto(User user);

    User convertUserDtoToUser(UserRequestDto userDto);

}
