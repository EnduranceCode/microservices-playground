package com.di4.bootcamp.subscriptions.services.imp;

import com.di4.bootcamp.subscriptions.dto.ProfileDto;
import com.di4.bootcamp.subscriptions.entities.Profile;
import com.di4.bootcamp.subscriptions.entities.Subscription;
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
            if (profileRepository.existsById(profileDto.getId())) {
                profile = profileRepository.getReferenceById(profileDto.getId());
                profile.setSubscription(subscription);
            } else {
                throw new NotFoundException(ExceptionConstants.NON_EXISTENT_PROFILE);
            }
        } else {
            profile = new Profile();
            profile.setName(profileDto.getName());
            profile.setAlias(profileDto.getAlias());
            profile.setAvatar(profileDto.getAvatar());
            profile.setSubscription(subscription);
        }

        try {
            profile = profileRepository.save(profile);
        } catch (final Exception exception) {
            LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, exception);
            throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
        }

        return modelMapper.map(profile, ProfileDto.class);
    }
}
