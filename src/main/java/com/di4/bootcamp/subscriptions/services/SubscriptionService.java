package com.di4.bootcamp.subscriptions.services;

import com.di4.bootcamp.subscriptions.dto.SubscriptionDto;
import java.util.List;

public interface SubscriptionService {

    public List<SubscriptionDto> getAllSubscriptions();
}
