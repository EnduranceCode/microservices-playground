package com.everis.d4i.tutorial.controllers.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.services.ActorService;
import com.everis.d4i.tutorial.utils.constants.RestConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ActorControllerImplTest {

    static final Long ACTOR_ID = 1L;
    static final String FIRST_ACTOR_NAME = "Michelle Fairley";
    static final String SECOND_ACTOR_NAME = "Sean Bean";

    @InjectMocks
    ActorControllerImpl actorController;

    @Mock
    ActorService actorService;

    ObjectWriter objectWriter;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

        mockMvc = MockMvcBuilders.standaloneSetup(actorController).build();
    }

    @Test
    public void getActors() throws Exception {
        ActorRest mockFirstActor = new ActorRest();
        mockFirstActor.setId(1L);
        mockFirstActor.setName(FIRST_ACTOR_NAME);
        ActorRest mockSecondActor = new ActorRest();
        mockSecondActor.setId(2L);
        mockSecondActor.setName(SECOND_ACTOR_NAME);
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
        mockActor.setName(FIRST_ACTOR_NAME);

        when(actorService.getActorById(ACTOR_ID)).thenReturn(mockActor);

        actorService.getActorById(ACTOR_ID);

        verify(actorService, times(1)).getActorById(anyLong());

        mockMvc.perform(get(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1
                + RestConstants.RESOURCE_ACTOR + URL)).andExpect(status().isOk());
    }

    @Test
    public void createActor() throws Exception {
        ActorRest mockActor = new ActorRest();
        mockActor.setName(FIRST_ACTOR_NAME);

        when(actorService.createActor(any())).thenReturn(mockActor);

        actorService.createActor(mockActor);

        verify(actorService, times(1)).createActor(mockActor);

        mockMvc.perform(post(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1
                       + RestConstants.RESOURCE_ACTOR).contentType(MediaType.APPLICATION_JSON_VALUE)
                                                      .accept(MediaType.APPLICATION_JSON)
                                                      .content(objectWriter.writeValueAsString(mockActor)))
               .andExpect(status().isOk());
    }

    @Test
    public void updateActor() throws Exception {
        final String NEW_NAME = "Emilia Clarke";
        final String URL = "/" + ACTOR_ID;

        ActorRest mockGivenActor = new ActorRest();
        mockGivenActor.setId(ACTOR_ID);
        mockGivenActor.setName(NEW_NAME);

        ActorRest mockUpdatedActor = new ActorRest();
        mockUpdatedActor.setId(ACTOR_ID);
        mockUpdatedActor.setName(NEW_NAME);

        when(actorService.updateActor(anyLong(), any())).thenReturn(mockUpdatedActor);

        actorController.updateActor(ACTOR_ID, mockGivenActor);

        verify(actorService, times(1)).updateActor(anyLong(), any());

        mockMvc.perform(patch(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1
                       + RestConstants.RESOURCE_ACTOR + URL).contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .accept(MediaType.APPLICATION_JSON).content(
                               objectWriter.writeValueAsString(mockGivenActor)))
               .andExpect(status().isOk());
    }
}
