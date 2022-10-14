package com.d4i.bootcamp.tvshows.controllers.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.d4i.bootcamp.tvshows.json.ActorRest;
import com.d4i.bootcamp.tvshows.json.ChapterRest;
import com.d4i.bootcamp.tvshows.json.SeasonRest;
import com.d4i.bootcamp.tvshows.services.ActorService;
import com.d4i.bootcamp.tvshows.services.ChapterService;
import com.d4i.bootcamp.tvshows.services.SeasonService;
import com.d4i.bootcamp.tvshows.utils.constants.RestConstants;
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

    @Mock
    ChapterService chapterService;

    @Mock
    SeasonService seasonService;

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

    @Test
    public void deleteActorById() throws Exception {
        final String URL = RestConstants.RESOURCE_ACTOR + "/" + ACTOR_ID;

        actorService.deleteById(ACTOR_ID);

        when(actorService.deleteById(anyLong())).thenReturn(new ActorRest());

        mockMvc.perform(delete(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + URL))
               .andExpect(status().isNoContent());
    }

    @Test
    public void getSeasonsByActorId() throws Exception {
        final String URL = RestConstants.RESOURCE_ACTOR_SEASON.replace("{id}",
                String.valueOf(ACTOR_ID));

        SeasonRest mockFirstSeason = new SeasonRest();
        mockFirstSeason.setId(1L);
        mockFirstSeason.setName("One");

        SeasonRest mockSecondSeason = new SeasonRest();
        mockSecondSeason.setId(1L);
        mockSecondSeason.setName("Two");

        List<SeasonRest> mockSeasons = new ArrayList<>();
        mockSeasons.add(mockFirstSeason);
        mockSeasons.add(mockSecondSeason);

        when(seasonService.getSeasonsByActorId(anyLong())).thenReturn(mockSeasons);

        actorController.getSeasonsByActorId(ACTOR_ID);

        verify(seasonService, times(1)).getSeasonsByActorId(anyLong());

        mockMvc.perform(get(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1
                + RestConstants.RESOURCE_ACTOR + URL)).andExpect(status().isOk());
    }

    @Test
    public void getChaptersByActorId() throws Exception {
        final String URL = RestConstants.RESOURCE_ACTOR_CHAPTER.replace("{id}",
                String.valueOf(ACTOR_ID));

        ChapterRest mockFirstChapter = new ChapterRest();
        mockFirstChapter.setId(1L);
        mockFirstChapter.setName("Capitulo 1");

        ChapterRest mockSecondChapter = new ChapterRest();
        mockSecondChapter.setId(1L);
        mockSecondChapter.setName("Capitulo 2");

        List<ChapterRest> mockChapters = new ArrayList<>();
        mockChapters.add(mockFirstChapter);
        mockChapters.add(mockSecondChapter);

        when(chapterService.getChaptersByActorId(anyLong())).thenReturn(mockChapters);

        actorController.getChaptersByActorId(ACTOR_ID);

        verify(chapterService, times(1)).getChaptersByActorId(anyLong());

        mockMvc.perform(get(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1
                + RestConstants.RESOURCE_ACTOR + URL)).andExpect(status().isOk());
    }
}
