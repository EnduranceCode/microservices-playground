package com.di4.bootcamp.controllers;

import com.di4.bootcamp.dto.SubscriptionDto;
import com.di4.bootcamp.responses.D4iBootcampResponse;
import java.util.List;

public interface SubscriptionController {

    public D4iBootcampResponse<List<SubscriptionDto>> getAllSubscriptions();
}
