package com.d4i.bootcamp.tvshows.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.d4i.bootcamp.tvshows.json.ActorRest;
import com.d4i.bootcamp.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.entities.Actor;
import com.d4i.bootcamp.tvshows.repositories.ActorRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ActorServiceImplTest {

    static final Long ACTOR_ID = 1L;
    static final String FIRST_ACTOR_NAME = "Michelle Fairley";
    static final String SECOND_ACTOR_NAME = "Sean Bean";

    @InjectMocks
    ActorServiceImpl actorService;

    @Mock
    ActorRepository actorRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getActors() throws D4iBootcampException {
        Actor mockFirstActor = new Actor();
        mockFirstActor.setId(1L);
        mockFirstActor.setName(FIRST_ACTOR_NAME);
        Actor mockSecondActor = new Actor();
        mockSecondActor.setId(2L);
        mockSecondActor.setName(SECOND_ACTOR_NAME);
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
    public void getActorById() throws D4iBootcampException {
        Actor mockActor = new Actor();
        mockActor.setId(ACTOR_ID);
        mockActor.setName(FIRST_ACTOR_NAME);

        when(actorRepository.getOne(anyLong())).thenReturn(mockActor);

        ActorRest actor = actorService.getActorById(ACTOR_ID);

        verify(actorRepository, times(1)).getOne(anyLong());
        assertEquals(ACTOR_ID, actor.getId());
    }

    @Test
    public void createActor() throws D4iBootcampException {
        Actor mockActor = new Actor();
        mockActor.setId(ACTOR_ID);
        mockActor.setName(FIRST_ACTOR_NAME);

        ActorRest mockActorRest = new ActorRest();
        mockActor.setName(FIRST_ACTOR_NAME);

        when(actorRepository.save(any())).thenReturn(mockActor);

        ActorRest actor = actorService.createActor(mockActorRest);

        verify(actorRepository, times(1)).save(any());
    }

    @Test
    public void updateActor() throws D4iBootcampException {
        final String NEW_NAME = "Emilia Clarke";

        ActorRest mockGivenActor = new ActorRest();
        mockGivenActor.setId(ACTOR_ID);
        mockGivenActor.setName(NEW_NAME);

        Actor mockExistingActor = new Actor();
        mockExistingActor.setId(ACTOR_ID);
        mockExistingActor.setName(FIRST_ACTOR_NAME);

        Actor mockupdatedActor = new Actor();
        mockupdatedActor.setId(ACTOR_ID);
        mockupdatedActor.setName(NEW_NAME);

        ArgumentCaptor<Actor> actorCaptor = ArgumentCaptor.forClass(Actor.class);

        when(actorRepository.getOne(ACTOR_ID)).thenReturn(mockExistingActor);
        when(actorRepository.save(actorCaptor.capture())).thenReturn(mockupdatedActor);

        ActorRest actor = actorService.updateActor(mockGivenActor.getId(), mockGivenActor);

        verify(actorRepository, times(1)).getOne(anyLong());
        verify(actorRepository, times(1)).save(any());

        assertEquals(mockGivenActor.getName(), actorCaptor.getValue().getName());
        assertEquals(mockGivenActor.getName(), actor.getName());
    }

    @Test
    public void deleteById() {
        actorRepository.deleteById(ACTOR_ID);

        verify(actorRepository, times(1)).deleteById(anyLong());
    }
}
