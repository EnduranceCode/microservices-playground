package com.nttdata.di4.netflixsubscriptions.controllers;

import com.nttdata.di4.netflixsubscriptions.dto.SubscriptionDto;
import com.nttdata.di4.netflixsubscriptions.responses.NetflixResponse;
import java.util.List;

public interface SubscriptionController {

    public NetflixResponse<List<SubscriptionDto>> getAllSubscriptions();
}
