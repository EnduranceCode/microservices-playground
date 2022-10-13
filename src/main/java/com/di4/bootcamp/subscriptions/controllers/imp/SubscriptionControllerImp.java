package com.di4.bootcamp.subscriptions.controllers.imp;

import com.di4.bootcamp.subscriptions.utils.constants.CommonConstants;
import com.di4.bootcamp.subscriptions.utils.constants.RestConstants;
import com.di4.bootcamp.subscriptions.controllers.SubscriptionController;
import com.di4.bootcamp.subscriptions.dto.SubscriptionDto;
import com.di4.bootcamp.subscriptions.responses.D4iBootcampResponse;
import com.di4.bootcamp.subscriptions.services.SubscriptionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public D4iBootcampResponse<List<SubscriptionDto>> getAllSubscriptions() {

        return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                CommonConstants.OK, subscriptionService.getAllSubscriptions());
    }
}
