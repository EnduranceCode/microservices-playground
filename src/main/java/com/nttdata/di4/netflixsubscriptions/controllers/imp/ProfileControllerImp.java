package com.nttdata.di4.netflixsubscriptions.controllers.imp;

import com.nttdata.di4.netflixsubscriptions.controllers.ProfileController;
import com.nttdata.di4.netflixsubscriptions.services.ProfileService;
import com.nttdata.di4.netflixsubscriptions.utils.constants.RestConstants;
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
