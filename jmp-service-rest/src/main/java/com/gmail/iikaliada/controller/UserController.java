package com.gmail.iikaliada.controller;

import com.gmail.iikaliada.dto.UserRequestDto;
import com.gmail.iikaliada.dto.UserResponseDto;
import com.gmail.iikaliada.serivce.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequestMapping("/api/userGroup")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Creates User", parameters = {
            @Parameter(name = "id", schema = @Schema(implementation = Long.class)),
            @Parameter(name = "name", schema = @Schema(implementation = String.class)),
            @Parameter(name = "surname", schema = @Schema(implementation = String.class)),
            @Parameter(name = "birthday", schema = @Schema(implementation = String.class))})
    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = UserResponseDto.class))),
            @ApiResponse(responseCode = "404", content = @Content)})
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public UserResponseDto createUser(@RequestBody UserRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    @Operation(summary = "Update existing User", parameters = {
            @Parameter(name = "id", schema = @Schema(implementation = Long.class)),
            @Parameter(name = "name", schema = @Schema(implementation = String.class)),
            @Parameter(name = "surname", schema = @Schema(implementation = String.class)),
            @Parameter(name = "birthday", schema = @Schema(implementation = String.class))})
    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", content = @Content)})
    @RequestMapping(value = "/users/update", method = RequestMethod.PUT)
    public UserResponseDto updateUser(@RequestBody UserRequestDto requestDto) {
        return userService.updateUser(requestDto);
    }

    @Operation(summary = "Delete existing User", parameters =
    @Parameter(name = "id", schema = @Schema(implementation = Long.class)))
    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = @Content)})
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @Operation(summary = "Get user by Id", parameters =
    @Parameter(name = "id", schema = @Schema(implementation = Long.class)))
    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", content = @Content)})
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public UserResponseDto getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @Operation(summary = "Get all existing users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", content = @Content)})
    @RequestMapping(value = "/users", method = RequestMethod.GET)
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
