package com.di4.bootcamp.subscriptions.controllers;

import com.di4.bootcamp.subscriptions.dto.SubscriptionDto;
import com.di4.bootcamp.subscriptions.responses.D4iBootcampResponse;
import java.util.List;

public interface SubscriptionController {

    public D4iBootcampResponse<List<SubscriptionDto>> getAllSubscriptions();
}
