package com.gmail.iikaliada.serivce;

import com.gmail.iikaliada.dto.SubscriptionRequestDto;
import com.gmail.iikaliada.dto.SubscriptionResponseDto;

import java.util.List;

public interface SubscriptionService {

    SubscriptionResponseDto createSubscription(SubscriptionRequestDto requestDto);

    SubscriptionResponseDto updateSubscription(SubscriptionRequestDto requestDto);

    void deleteSubscription(Long id);

    SubscriptionResponseDto getSubscription(Long id);

    List<SubscriptionResponseDto> getAllSubscription();

}
