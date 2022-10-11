package com.nttdata.di4.netflixsubscriptions.controllers.imp;

import com.nttdata.di4.netflixsubscriptions.controllers.SubscriptionController;
import com.nttdata.di4.netflixsubscriptions.services.SubscriptionService;
import com.nttdata.di4.netflixsubscriptions.utils.constants.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1
        + RestConstants.RESOURCE_SUBSCRIPTION)
public class SubscriptionControllerImp implements SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionControllerImp(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }
}
