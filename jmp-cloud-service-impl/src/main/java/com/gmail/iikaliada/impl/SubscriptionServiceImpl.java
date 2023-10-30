package com.gmail.iikaliada.impl;

import com.gmail.iikaliada.converter.SubscriptionConverter;
import com.gmail.iikaliada.dto.SubscriptionRequestDto;
import com.gmail.iikaliada.dto.SubscriptionResponseDto;
import com.gmail.iikaliada.entity.Subscription;
import com.gmail.iikaliada.repository.SubscriptionRepository;
import com.gmail.iikaliada.serivce.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private static final String SUBSCRIPTION_NOT_FOUND_ERROR = "Subscription with id = %d is not found";

    private final SubscriptionRepository subscriptionRepository;

    private final SubscriptionConverter subscriptionConverter;

    @Override
    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto requestDto) {
        Subscription subscription = subscriptionConverter.convertSubscriptionDtoToSubscription(requestDto);
        subscription.setStartDate(LocalDate.now());
        return subscriptionConverter.convertSubscriptionToSubscriptionDto(subscriptionRepository.save(subscription));
    }

    @Override
    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto requestDto) {
        Optional<Subscription> existingSubscription = subscriptionRepository.findById(requestDto.getId());
        if (existingSubscription.isPresent()) {
            Subscription subscription = subscriptionConverter.convertSubscriptionDtoToSubscription(requestDto);
            subscription.setStartDate(existingSubscription.get().getStartDate());
            return subscriptionConverter.convertSubscriptionToSubscriptionDto(subscriptionRepository.save(subscription));
        } else {
            throw new NoSuchElementException(String.format(SUBSCRIPTION_NOT_FOUND_ERROR, requestDto.getId()));
        }
    }

    @Override
    public void deleteSubscription(Long id) {
        try {
            subscriptionRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchElementException(String.format(SUBSCRIPTION_NOT_FOUND_ERROR, id));
        }
    }

    @Override
    public SubscriptionResponseDto getSubscription(Long id) {
        Optional<Subscription> subscription = subscriptionRepository.findById(id);
        if (subscription.isPresent()) {
            return subscriptionConverter.convertSubscriptionToSubscriptionDto(subscription.get());
        } else {
            throw new NoSuchElementException(String.format(SUBSCRIPTION_NOT_FOUND_ERROR, id));
        }
    }

    @Override
    public List<SubscriptionResponseDto> getAllSubscription() {
        List<SubscriptionResponseDto> userResponseDtos = new ArrayList<>();
        subscriptionRepository.findAll().forEach(subscription ->
                userResponseDtos.add(subscriptionConverter.convertSubscriptionToSubscriptionDto(subscription)));
        return userResponseDtos;
    }

}
