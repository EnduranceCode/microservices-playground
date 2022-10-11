package com.nttdata.di4.netflixsubscriptions.controllers.imp;

import com.nttdata.di4.netflixsubscriptions.controllers.SubscriptionController;
import com.nttdata.di4.netflixsubscriptions.dto.SubscriptionDto;
import com.nttdata.di4.netflixsubscriptions.responses.NetflixResponse;
import com.nttdata.di4.netflixsubscriptions.services.SubscriptionService;
import com.nttdata.di4.netflixsubscriptions.utils.constants.CommonConstants;
import com.nttdata.di4.netflixsubscriptions.utils.constants.RestConstants;
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
    public NetflixResponse<List<SubscriptionDto>> getAllSubscriptions() {

        return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                CommonConstants.OK, subscriptionService.getAllSubscriptions());
    }
}
