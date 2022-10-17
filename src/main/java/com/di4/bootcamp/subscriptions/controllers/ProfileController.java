package com.di4.bootcamp.subscriptions.controllers;

import com.di4.bootcamp.subscriptions.dto.ProfileDto;
import com.di4.bootcamp.subscriptions.exceptions.D4iBootcampException;
import com.di4.bootcamp.subscriptions.responses.D4iBootcampResponse;

public interface ProfileController {

    D4iBootcampResponse<ProfileDto> addProfile(Long subscriptionId, ProfileDto profileDto)
            throws D4iBootcampException;

    D4iBootcampResponse<ProfileDto> updateProfile(Long subscriptionId, Long profileId,
            ProfileDto profileDto) throws D4iBootcampException;
}
