package com.gmail.iikaliada.controller;

import com.gmail.iikaliada.dto.SubscriptionRequestDto;
import com.gmail.iikaliada.dto.SubscriptionResponseDto;
import com.gmail.iikaliada.serivce.SubscriptionService;
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

@RequestMapping("/api/subscriptionGroup")
@RestController
@RequiredArgsConstructor
public class ServiceController {

    private final SubscriptionService subscriptionService;

    @Operation(summary = "Creates Subscription", parameters = {
            @Parameter(name = "id", schema = @Schema(implementation = Long.class)),
            @Parameter(name = "userId", schema = @Schema(implementation = Long.class))})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = SubscriptionResponseDto.class))),
            @ApiResponse(responseCode = "404", content = @Content)})
    @RequestMapping(value = "/subscriptions", method = RequestMethod.POST)
    public SubscriptionResponseDto createSubscription(@RequestBody SubscriptionRequestDto requestDto) {
        return subscriptionService.createSubscription(requestDto);
    }

    @Operation(summary = "Updates Subscription", parameters = {
            @Parameter(name = "id", schema = @Schema(implementation = Long.class)),
            @Parameter(name = "userId", schema = @Schema(implementation = Long.class))})
    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = SubscriptionResponseDto.class))),
            @ApiResponse(responseCode = "404", content = @Content)})
    @RequestMapping(value = "/subscriptions/update", method = RequestMethod.PUT)
    public SubscriptionResponseDto updateSubscription(@RequestBody SubscriptionRequestDto requestDto) {
        return subscriptionService.updateSubscription(requestDto);
    }

    @Operation(summary = "Delete Subscription", parameters =
    @Parameter(name = "id", schema = @Schema(implementation = Long.class)))
    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", content = @Content)})
    @RequestMapping(value = "/subscriptions/{id}", method = RequestMethod.DELETE)
    public void deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
    }

    @Operation(summary = "Get Subscription by Id", parameters =
    @Parameter(name = "id", schema = @Schema(implementation = Long.class)))
    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = SubscriptionResponseDto.class))),
            @ApiResponse(responseCode = "404", content = @Content)})
    @RequestMapping(value = "/subscriptions/{id}", method = RequestMethod.GET)
    public SubscriptionResponseDto getSubscription(@PathVariable Long id) {
        return subscriptionService.getSubscription(id);
    }

    @Operation(summary = "Get All Subscriptions")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "404", content = @Content)})
    @RequestMapping(value = "/subscriptions", method = RequestMethod.GET)
    public List<SubscriptionResponseDto> getAllSubscription() {
        return subscriptionService.getAllSubscription();
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<Object> handleSubscriptionNotFound(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                ex.getMessage(), new HttpHeaders(), NOT_FOUND);
    }

}
