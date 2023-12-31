package com.gmail.iikaliada.controller;

import com.gmail.iikaliada.dto.SubscriptionRequestDto;
import com.gmail.iikaliada.dto.SubscriptionResponseDto;
import com.gmail.iikaliada.serivce.SubscriptionService;
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

@RequestMapping("/api/subscriptions")
@RestController
@RequiredArgsConstructor
public class ServiceController implements ServiceApi{

    private final SubscriptionService subscriptionService;

    @PostMapping()
    public SubscriptionResponseDto createSubscription(@RequestBody SubscriptionRequestDto requestDto) {
        return subscriptionService.createSubscription(requestDto);
    }

    @PutMapping()
    public SubscriptionResponseDto updateSubscription(@RequestBody SubscriptionRequestDto requestDto) {
        return subscriptionService.updateSubscription(requestDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
    }

    @GetMapping(value = "/{id}")
    public SubscriptionResponseDto getSubscription(@PathVariable Long id) {
        return subscriptionService.getSubscription(id);
    }

    @GetMapping()
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
