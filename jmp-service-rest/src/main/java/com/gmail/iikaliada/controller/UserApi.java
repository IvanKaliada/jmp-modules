package com.gmail.iikaliada.controller;


import com.gmail.iikaliada.dto.UserRequestDto;
import com.gmail.iikaliada.dto.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Tag(name = "User Api", description = "Actions that allows users to manipulate user")
public interface UserApi {

    @Operation(summary = "Creates User")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = UserResponseDto.class))),
            @ApiResponse(responseCode = "404", content = @Content)})
    UserResponseDto createUser(@RequestBody UserRequestDto requestDto);

    @Operation(summary = "Update existing User")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = UserResponseDto.class))),
            @ApiResponse(responseCode = "404", content = @Content)})
    @RequestMapping(value = "/users/update", method = RequestMethod.PUT)
    UserResponseDto updateUser(@RequestBody UserRequestDto requestDto);

    @Operation(summary = "Delete existing User")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = @Content)})
    void deleteUser(@PathVariable("id") Long id);

    @Operation(summary = "Get user by Id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = UserResponseDto.class))),
            @ApiResponse(responseCode = "404", content = @Content)})
    UserResponseDto getUser(@PathVariable("id") Long id);

    @Operation(summary = "Get all existing users")
    @ApiResponses(value = @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class)))))
    List<UserResponseDto> getAllUser();
}
