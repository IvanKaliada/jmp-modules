package com.gmail.iikaliada.impl;

import com.gmail.iikaliada.converter.SubscriptionConverter;
import com.gmail.iikaliada.dto.SubscriptionRequestDto;
import com.gmail.iikaliada.dto.SubscriptionResponseDto;
import com.gmail.iikaliada.entity.Subscription;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionConverterImpl implements SubscriptionConverter {

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public SubscriptionResponseDto convertSubscriptionToSubscriptionDto(Subscription subscription) {
        return modelMapper.map(subscription, SubscriptionResponseDto.class);
    }

    @Override
    public Subscription convertSubscriptionDtoToSubscription(SubscriptionRequestDto subscriptionDto) {
        return modelMapper.map(subscriptionDto, Subscription.class);
    }

}
