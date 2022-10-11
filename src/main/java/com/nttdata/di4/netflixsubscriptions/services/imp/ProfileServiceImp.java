package com.nttdata.di4.netflixsubscriptions.services.imp;

import com.nttdata.di4.netflixsubscriptions.repositories.ProfileRepository;
import com.nttdata.di4.netflixsubscriptions.services.ProfileService;
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
