package com.di4.bootcamp.subscriptions.services.imp;

import com.di4.bootcamp.subscriptions.repositories.ProfileRepository;
import com.di4.bootcamp.subscriptions.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImp implements ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImp(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }
}
