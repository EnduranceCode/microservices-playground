package com.di4.bootcamp.subscriptions.controllers.imp;

import com.di4.bootcamp.subscriptions.controllers.ProfileController;
import com.di4.bootcamp.subscriptions.utils.constants.RestConstants;
import com.di4.bootcamp.subscriptions.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1
        + RestConstants.RESOURCE_PROFILE)
public class ProfileControllerImp implements ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileControllerImp(ProfileService profileService) {
        this.profileService = profileService;
    }
}
