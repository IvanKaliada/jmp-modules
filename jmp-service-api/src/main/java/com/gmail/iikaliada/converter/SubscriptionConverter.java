package com.gmail.iikaliada.converter;

import com.gmail.iikaliada.dto.SubscriptionRequestDto;
import com.gmail.iikaliada.dto.SubscriptionResponseDto;
import com.gmail.iikaliada.entity.Subscription;

public interface SubscriptionConverter {

    SubscriptionResponseDto toSubscriptionDto(Subscription subscription);

    Subscription toSubscription(SubscriptionRequestDto subscriptionDto);

}
