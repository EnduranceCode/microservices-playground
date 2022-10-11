package com.nttdata.di4.netflixsubscriptions.services;

import com.nttdata.di4.netflixsubscriptions.dto.SubscriptionDto;
import java.util.List;

public interface SubscriptionService {

    public List<SubscriptionDto> getAllSubscriptions();
}
