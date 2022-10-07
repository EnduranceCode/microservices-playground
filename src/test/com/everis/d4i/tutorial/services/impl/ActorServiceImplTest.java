package com.everis.d4i.tutorial.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.everis.d4i.tutorial.entities.Actor;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.repositories.ActorRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ActorServiceImplTest {

    @InjectMocks
    ActorServiceImpl actorService;

    @Mock
    ActorRepository actorRepository;

    static final Long ACTOR_ID = 1L;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getActors() {
        Actor mockFirstActor = new Actor();
        mockFirstActor.setId(1L);
        mockFirstActor.setName("Michelle Fairley");
        Actor mockSecondActor = new Actor();
        mockSecondActor.setId(2L);
        mockSecondActor.setName("Sean Bean");
        List<Actor> mockActors = new ArrayList<>();
        mockActors.add(mockFirstActor);
        mockActors.add(mockSecondActor);

        when(actorRepository.findAll()).thenReturn(mockActors);

        List<ActorRest> actors = actorService.getActors();

        verify(actorRepository, times(1)).findAll();
        assertNotNull(actors);
        assertEquals(2, actors.size());
    }

    @Test
    public void getActorById() throws NetflixException {
        Actor mockActor = new Actor();
        mockActor.setId(ACTOR_ID);
        mockActor.setName("Michelle Fairley");

        when(actorRepository.getOne(anyLong())).thenReturn(mockActor);

        ActorRest actor = actorService.getActorById(ACTOR_ID);

        verify(actorRepository, times(1)).getOne(anyLong());
        assertEquals(ACTOR_ID, actor.getId());
    }
}
