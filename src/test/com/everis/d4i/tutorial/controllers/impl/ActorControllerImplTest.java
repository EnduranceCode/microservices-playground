package com.everis.d4i.tutorial.controllers.impl;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.services.ActorService;
import com.everis.d4i.tutorial.utils.constants.RestConstants;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ActorControllerImplTest {

    static final Long ACTOR_ID = 1L;

    @InjectMocks
    ActorControllerImpl actorController;

    @Mock
    ActorService actorService;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(actorController).build();
    }

    @Test
    public void getActors() throws Exception {
        ActorRest mockFirstActor = new ActorRest();
        mockFirstActor.setId(1L);
        mockFirstActor.setName("Michelle Fairley");
        ActorRest mockSecondActor = new ActorRest();
        mockSecondActor.setId(2L);
        mockSecondActor.setName("Sean Bean");
        List<ActorRest> mockActors = new ArrayList<>();
        mockActors.add(mockFirstActor);
        mockActors.add(mockSecondActor);

        when(actorService.getActors()).thenReturn(mockActors);

        actorController.getActors();

        verify(actorService, times(1)).getActors();

        mockMvc.perform(get(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1
                + RestConstants.RESOURCE_ACTOR)).andExpect(status().isOk());
    }

    @Test
    public void getActorById() throws Exception {
        final String URL = "/" + ACTOR_ID;

        ActorRest mockActor = new ActorRest();
        mockActor.setId(ACTOR_ID);
        mockActor.setName("Michelle Fairley");

        when(actorService.getActorById(ACTOR_ID)).thenReturn(mockActor);

        actorService.getActorById(ACTOR_ID);

        verify(actorService, times(1)).getActorById(anyLong());

        mockMvc.perform(get(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1
                + RestConstants.RESOURCE_ACTOR + URL)).andExpect(status().isOk());
    }
}
