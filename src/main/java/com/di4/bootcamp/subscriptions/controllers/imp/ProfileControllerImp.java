package com.di4.bootcamp.subscriptions.controllers.imp;

import com.di4.bootcamp.subscriptions.controllers.ProfileController;
import com.di4.bootcamp.subscriptions.dto.ProfileDto;
import com.di4.bootcamp.subscriptions.exceptions.D4iBootcampException;
import com.di4.bootcamp.subscriptions.responses.D4iBootcampResponse;
import com.di4.bootcamp.subscriptions.services.ProfileService;
import com.di4.bootcamp.subscriptions.utils.constants.CommonConstants;
import com.di4.bootcamp.subscriptions.utils.constants.RestConstants;
import io.swagger.annotations.ApiParam;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public D4iBootcampResponse<ProfileDto> addProfile(@PathVariable Long subscriptionId,
            @ApiParam(value = RestConstants.PARAMETER_SUBSCRIPTION, required = true) @RequestBody
            @Valid final ProfileDto profileDto) throws D4iBootcampException {

        return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                CommonConstants.OK, profileService.addProfile(subscriptionId, profileDto));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = RestConstants.RESOURCE_PROFILE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public D4iBootcampResponse<ProfileDto> updateProfile(@PathVariable Long subscriptionId,
            @PathVariable Long profileId, @RequestBody @Valid final ProfileDto profileDto)
            throws D4iBootcampException {

        return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                CommonConstants.OK,
                profileService.updateProfile(subscriptionId, profileId, profileDto));
    }
}
