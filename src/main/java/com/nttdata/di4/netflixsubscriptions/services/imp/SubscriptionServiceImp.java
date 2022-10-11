package com.nttdata.di4.netflixsubscriptions.services.imp;

import com.nttdata.di4.netflixsubscriptions.repositories.SubscriptionRepository;
import com.nttdata.di4.netflixsubscriptions.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImp implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionServiceImp(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }
}
