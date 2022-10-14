package com.di4.bootcamp.subscriptions.services.imp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.di4.bootcamp.subscriptions.dto.SubscriptionDto;
import com.di4.bootcamp.subscriptions.repositories.SubscriptionRepository;
import com.di4.bootcamp.subscriptions.entities.Profile;
import com.di4.bootcamp.subscriptions.entities.Subscription;
import com.di4.bootcamp.subscriptions.services.imp.SubscriptionServiceImp;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class SubscriptionServiceImpTest {

    @InjectMocks
    SubscriptionServiceImp subscriptionServiceImp;

    @Mock
    SubscriptionRepository subscriptionRepository;

    Subscription mockFirstSubscription;
    Subscription mockSecondSubscription;
    List<Subscription> mockSubscriptions;
    Profile mockFirstProfile;
    Profile mockSecondProfile;

    @BeforeEach
    void setUp() {
        mockFirstSubscription = new Subscription();
        mockFirstSubscription.setId(1L);
        mockFirstSubscription.setType("BASIC");
        mockFirstSubscription.setPrice(BigDecimal.valueOf(7.99));
        mockFirstSubscription.setStartDate(LocalDate.of(2022, 10, 1));
        mockFirstSubscription.setEndDate(LocalDate.of(2023, 9, 30));

        mockSecondSubscription = new Subscription();
        mockSecondSubscription.setId(1L);
        mockSecondSubscription.setType("PREMIUM");
        mockSecondSubscription.setPrice(BigDecimal.valueOf(15.99));
        mockSecondSubscription.setStartDate(LocalDate.of(2022, 10, 1));
        mockSecondSubscription.setEndDate(LocalDate.of(2023, 9, 30));

        mockFirstProfile = new Profile();
        mockFirstProfile.setId(1L);
        mockFirstProfile.setName("John Doe");
        mockFirstProfile.setAlias("MysteryMan");
        mockFirstProfile.setSubscription(mockFirstSubscription);

        mockSecondProfile = new Profile();
        mockSecondProfile.setId(1L);
        mockSecondProfile.setName("Jane Doe");
        mockSecondProfile.setAlias("MysteryWoman");
        mockSecondProfile.setSubscription(mockSecondSubscription);

        mockSubscriptions = new ArrayList<>();
        mockSubscriptions.add(mockFirstSubscription);
        mockSubscriptions.add(mockSecondSubscription);
    }

    @Test
    void getAllSubscriptions() {
        when(subscriptionRepository.findAll()).thenReturn(mockSubscriptions);

        List<SubscriptionDto> subscriptions = subscriptionServiceImp.getAllSubscriptions();

        verify(subscriptionRepository, times(1)).findAll();
        assertEquals(2, subscriptions.size());
    }
}
