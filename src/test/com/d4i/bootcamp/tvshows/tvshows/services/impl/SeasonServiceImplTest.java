package com.d4i.bootcamp.tvshows.tvshows.services.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.d4i.bootcamp.tvshows.tvshows.entities.Season;
import com.d4i.bootcamp.tvshows.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.tvshows.json.SeasonRest;
import com.d4i.bootcamp.tvshows.tvshows.repositories.SeasonRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SeasonServiceImplTest {

    @InjectMocks
    SeasonServiceImpl seasonService;

    @Mock
    SeasonRepository seasonRepository;

    static final Long ACTOR_ID = 1L;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getSeasonsByActorId() throws D4iBootcampException {
        Season mockFirstSeason = new Season();
        mockFirstSeason.setId(1L);
        mockFirstSeason.setName("One");

        Season mockSecondSeason = new Season();
        mockSecondSeason.setId(1L);
        mockSecondSeason.setName("Two");

        List<Season> mockSeasons = new ArrayList<>();
        mockSeasons.add(mockFirstSeason);
        mockSeasons.add(mockSecondSeason);

        when(seasonRepository.getSeasonsByActorId(anyLong())).thenReturn(mockSeasons);

        List<SeasonRest> seasons = seasonService.getSeasonsByActorId(ACTOR_ID);

        verify(seasonRepository, times(1)).getSeasonsByActorId(anyLong());

        assertEquals(mockSeasons.size(), seasons.size());
    }
}
