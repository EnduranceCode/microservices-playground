package com.d4i.bootcamp.tvshows.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.d4i.bootcamp.tvshows.json.AwardRest;
import com.d4i.bootcamp.tvshows.entities.Award;
import com.d4i.bootcamp.tvshows.repositories.AwardRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AwardServiceImplTest {

    static final Long TV_SHOW_ID = 1L;
    static final String FIRST_AWARD_NAME = "American Film Institute Awards";
    static final String SECOND_AWARD_NAME = "Primetime Emmy Award";

    @InjectMocks
    AwardServiceImpl awardService;

    @Mock
    AwardRepository awardRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAwardsByTvShowId() {
        Award mockFirstAward = new Award();
        mockFirstAward.setId(1L);
        mockFirstAward.setName(FIRST_AWARD_NAME);
        Award mockSecondAward = new Award();
        mockSecondAward.setId(2L);
        mockSecondAward.setName(SECOND_AWARD_NAME);
        List<Award> mockAwards = new ArrayList<>();
        mockAwards.add(mockFirstAward);
        mockAwards.add(mockSecondAward);

        when(awardRepository.getAwardsByTvShowId(anyLong())).thenReturn(mockAwards);

        List<AwardRest> awards = awardService.getAwardsByTvShowId(TV_SHOW_ID);

        verify(awardRepository, times(1)).getAwardsByTvShowId(anyLong());

        assertNotNull(awards);
        assertEquals(2, awards.size());
    }
}
