package com.di4.bootcamp.subscriptions.controllers.imp;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.di4.bootcamp.subscriptions.dto.ProfileDto;
import com.di4.bootcamp.subscriptions.dto.SubscriptionDto;
import com.di4.bootcamp.subscriptions.services.SubscriptionService;
import com.di4.bootcamp.subscriptions.utils.constants.RestConstants;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
class SubscriptionControllerImpTest {

    @InjectMocks
    SubscriptionControllerImp subscriptionController;

    @Mock
    SubscriptionService subscriptionService;

    MockMvc mockMvc;

    SubscriptionDto mockFirstSubscription;
    SubscriptionDto mockSecondSubscription;
    List<SubscriptionDto> mockSubscriptions;
    ProfileDto mockFirstProfile;
    ProfileDto mockSecondProfile;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(subscriptionController).build();

        mockFirstSubscription = new SubscriptionDto();
        mockFirstSubscription.setId(1L);
        mockFirstSubscription.setType("BASIC");
        mockFirstSubscription.setPrice(BigDecimal.valueOf(7.99));
        mockFirstSubscription.setStartDate(LocalDate.of(2022, 10, 1));
        mockFirstSubscription.setEndDate(LocalDate.of(2023, 9, 30));

        mockSecondSubscription = new SubscriptionDto();
        mockSecondSubscription.setId(1L);
        mockSecondSubscription.setType("PREMIUM");
        mockSecondSubscription.setPrice(BigDecimal.valueOf(15.99));
        mockSecondSubscription.setStartDate(LocalDate.of(2022, 10, 1));
        mockSecondSubscription.setEndDate(LocalDate.of(2023, 9, 30));

        mockFirstProfile = new ProfileDto();
        mockFirstProfile.setId(1L);
        mockFirstProfile.setName("John Doe");
        mockFirstProfile.setAlias("MysteryMan");

        mockSecondProfile = new ProfileDto();
        mockSecondProfile.setId(1L);
        mockSecondProfile.setName("Jane Doe");
        mockSecondProfile.setAlias("MysteryWoman");

        mockSubscriptions = new ArrayList<>();
        mockSubscriptions.add(mockFirstSubscription);
        mockSubscriptions.add(mockSecondSubscription);
    }

    @Test
    void getAllSubscriptions() throws Exception {
        final String URL = "/subscriptions";

        when(subscriptionService.getAllSubscriptions()).thenReturn(mockSubscriptions);

        subscriptionController.getAllSubscriptions();

        verify(subscriptionService, times(1)).getAllSubscriptions();
        mockMvc.perform(get(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + URL))
               .andExpect(status().isOk());
    }
}
