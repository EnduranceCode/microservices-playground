package com.di4.bootcamp.subscriptions.services.imp;

import com.di4.bootcamp.subscriptions.repositories.SubscriptionRepository;
import com.di4.bootcamp.subscriptions.dto.SubscriptionDto;
import com.di4.bootcamp.subscriptions.services.SubscriptionService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImp implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public SubscriptionServiceImp(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public List<SubscriptionDto> getAllSubscriptions() {

        return subscriptionRepository.findAll().stream()
                                     .map(subscription -> modelMapper.map(subscription,
                                             SubscriptionDto.class)).collect(Collectors.toList());
    }
}
