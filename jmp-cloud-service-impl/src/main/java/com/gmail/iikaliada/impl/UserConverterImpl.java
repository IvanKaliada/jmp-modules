package com.gmail.iikaliada.impl;

import com.gmail.iikaliada.converter.UserConverter;
import com.gmail.iikaliada.dto.UserRequestDto;
import com.gmail.iikaliada.dto.UserResponseDto;
import com.gmail.iikaliada.entity.User;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class UserConverterImpl implements UserConverter {

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserResponseDto convertUserToUserDto(User user) {
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Override
    public User convertUserDtoToUser(UserRequestDto userDto) {
        Converter<String, LocalDate> toStringDate = localDateConverter();
        modelMapper.addConverter(toStringDate);
        return modelMapper.map(userDto, User.class);
    }

    private static Converter<String, LocalDate> localDateConverter() {
        return new AbstractConverter<>() {
            @Override
            protected LocalDate convert(String source) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                return LocalDate.parse(source, format);
            }
        };
    }

}
