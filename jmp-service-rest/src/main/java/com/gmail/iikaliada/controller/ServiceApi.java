package com.gmail.iikaliada.controller;

import com.gmail.iikaliada.dto.SubscriptionRequestDto;
import com.gmail.iikaliada.dto.SubscriptionResponseDto;
import com.gmail.iikaliada.dto.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface ServiceApi {

    @Operation(summary = "Creates Subscription")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = SubscriptionResponseDto.class))),
            @ApiResponse(responseCode = "404", content = @Content)})
    @RequestMapping(value = "/subscriptions", method = RequestMethod.POST)
    SubscriptionResponseDto createSubscription(@RequestBody SubscriptionRequestDto requestDto);

    @Operation(summary = "Updates Subscription")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = SubscriptionResponseDto.class))),
            @ApiResponse(responseCode = "404", content = @Content)})
    SubscriptionResponseDto updateSubscription(@RequestBody SubscriptionRequestDto requestDto);

    @Operation(summary = "Delete Subscription")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", content = @Content)})
    void deleteSubscription(@PathVariable Long id);

    @Operation(summary = "Get Subscription by Id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = SubscriptionResponseDto.class))),
            @ApiResponse(responseCode = "404", content = @Content)})
    SubscriptionResponseDto getSubscription(@PathVariable Long id);

    @Operation(summary = "Get All Subscriptions")
    @ApiResponses(value = @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class)))))
    List<SubscriptionResponseDto> getAllSubscription();

}
