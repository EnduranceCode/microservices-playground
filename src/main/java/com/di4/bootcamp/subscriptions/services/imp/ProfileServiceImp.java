package com.di4.bootcamp.subscriptions.services.imp;

import com.di4.bootcamp.subscriptions.dto.ProfileDto;
import com.di4.bootcamp.subscriptions.entities.Profile;
import com.di4.bootcamp.subscriptions.entities.Subscription;
import com.di4.bootcamp.subscriptions.exceptions.BadRequestException;
import com.di4.bootcamp.subscriptions.exceptions.D4iBootcampException;
import com.di4.bootcamp.subscriptions.exceptions.InternalServerErrorException;
import com.di4.bootcamp.subscriptions.exceptions.NotFoundException;
import com.di4.bootcamp.subscriptions.repositories.ProfileRepository;
import com.di4.bootcamp.subscriptions.repositories.SubscriptionRepository;
import com.di4.bootcamp.subscriptions.services.ProfileService;
import com.di4.bootcamp.subscriptions.utils.constants.ExceptionConstants;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImp implements ProfileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileServiceImp.class);

    private final ProfileRepository profileRepository;

    private final SubscriptionRepository subscriptionRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ProfileServiceImp(ProfileRepository profileRepository,
            SubscriptionRepository subscriptionRepository) {
        this.profileRepository = profileRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public ProfileDto addProfile(Long subscriptionId, ProfileDto profileDto)
            throws D4iBootcampException {

        Subscription subscription;
        if (subscriptionRepository.existsById(subscriptionId)) {
            subscription = subscriptionRepository.getReferenceById(subscriptionId);
        } else {
            throw new NotFoundException(ExceptionConstants.NON_EXISTENT_SUBSCRIPTION);
        }

        Profile profile;
        if (profileDto.getId() != null) {
            profile = getProfile(profileDto.getId());
            profile.setSubscription(subscription);
        } else {
            profile = new Profile();
            profile.setName(profileDto.getName());
            profile.setAlias(profileDto.getAlias());
            profile.setAvatar(profileDto.getAvatar());
            profile.setSubscription(subscription);
        }

        return modelMapper.map(saveProfile(profile), ProfileDto.class);
    }

    @Override
    public ProfileDto updateProfile(Long subscriptionId, Long profileId, ProfileDto profileDto)
            throws D4iBootcampException {

        Profile profile = getProfile(profileId);

        if (!profile.getSubscription().getId().equals(subscriptionId)) {
            throw new BadRequestException(ExceptionConstants.BAD_REQUEST_PROFILE);
        }

        if (profileDto.getName() != null) {
            profile.setName(profileDto.getName());
        }
        if (profileDto.getAlias() != null) {
            profile.setAlias(profileDto.getAlias());
        }
        if (profileDto.getAvatar() != null) {
            profile.setAvatar(profileDto.getAvatar());
        }

        return modelMapper.map(saveProfile(profile), ProfileDto.class);
    }

    private Profile getProfile(Long profileId) throws NotFoundException {

        Profile profile;
        if (profileRepository.existsById(profileId)) {
            profile = profileRepository.getReferenceById(profileId);
        } else {
            throw new NotFoundException(ExceptionConstants.NON_EXISTENT_PROFILE);
        }

        return profile;
    }

    private Profile saveProfile(Profile profile) throws InternalServerErrorException {

        try {
            profile = profileRepository.save(profile);
        } catch (final Exception exception) {
            LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, exception);
            throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
        }
        return profile;
    }
}
