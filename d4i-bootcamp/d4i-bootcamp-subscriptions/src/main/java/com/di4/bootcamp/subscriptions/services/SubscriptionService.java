package com.di4.bootcamp.subscriptions.services;

import com.di4.bootcamp.subscriptions.dto.SubscriptionDto;
import com.di4.bootcamp.subscriptions.exceptions.D4iBootcampException;
import java.util.List;

public interface SubscriptionService {

    public SubscriptionDto createSubscription(SubscriptionDto subscriptionDto)
            throws D4iBootcampException;

    public SubscriptionDto updateSubscription(Long subscriptionId, SubscriptionDto subscriptionDto)
            throws D4iBootcampException;

    public List<SubscriptionDto> getAllSubscriptions();
}
