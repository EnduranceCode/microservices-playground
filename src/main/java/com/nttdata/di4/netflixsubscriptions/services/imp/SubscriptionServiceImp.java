package com.nttdata.di4.netflixsubscriptions.services.imp;

import com.nttdata.di4.netflixsubscriptions.dto.SubscriptionDto;
import com.nttdata.di4.netflixsubscriptions.repositories.SubscriptionRepository;
import com.nttdata.di4.netflixsubscriptions.services.SubscriptionService;
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
