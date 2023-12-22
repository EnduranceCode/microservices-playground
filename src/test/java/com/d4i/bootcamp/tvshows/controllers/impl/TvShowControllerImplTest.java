package com.d4i.bootcamp.tvshows.controllers.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.d4i.bootcamp.tvshows.json.AwardRest;
import com.d4i.bootcamp.tvshows.json.CategoryRest;
import com.d4i.bootcamp.tvshows.json.TvShowRest;
import com.d4i.bootcamp.tvshows.services.AwardService;
import com.d4i.bootcamp.tvshows.services.TvShowService;
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

public class TvShowControllerImplTest {

    static final Long CATEGORY_ID = 1L;
    static final Long TV_SHOW_ID = 1L;
    static final String FIRST_AWARD_NAME = "American Film Institute Awards";
    static final String SECOND_AWARD_NAME = "Primetime Emmy Award";

    @InjectMocks
    TvShowControllerImpl tvShowController;

    @Mock
    AwardService awardService;

    @Mock
    TvShowService tvShowService;

    ObjectWriter objectWriter;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

        mockMvc = MockMvcBuilders.standaloneSetup(tvShowController).build();
    }

    @Test
    public void getTvShowsByCategory() throws Exception {
        final String URL = RestConstants.RESOURCE_TV_SHOW + "?categoryId=" + CATEGORY_ID;
        CategoryRest mockCategory = new CategoryRest();
        mockCategory.setId(CATEGORY_ID);
        List<CategoryRest> mockCategories = new ArrayList<>();
        mockCategories.add(mockCategory);

        TvShowRest mockTvShow = new TvShowRest();
        mockTvShow.setCategories(mockCategories);

        List<TvShowRest> mockTvShows = new ArrayList<>();
        mockTvShows.add(mockTvShow);

        when(tvShowService.getTvShowsByCategory(anyLong())).thenReturn(mockTvShows);

        tvShowController.getTvShowsByCategory(CATEGORY_ID);

        verify(tvShowService, times(1)).getTvShowsByCategory(anyLong());

        mockMvc.perform(get(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + URL))
               .andExpect(status().isOk());
    }

    @Test
    public void patchTvShowName() throws Exception {
        final String OLD_NAME = "Old TV Show name";
        final String NEW_NAME = "New TV Show name";
        final String URL = RestConstants.RESOURCE_TV_SHOW + "/" + TV_SHOW_ID;

        TvShowRest mockGivenTvShow = new TvShowRest();
        mockGivenTvShow.setName(OLD_NAME);

        TvShowRest mockPatchedTvShow = new TvShowRest();
        mockPatchedTvShow.setName(NEW_NAME);

        when(tvShowService.patchTvShowName(anyLong(), any())).thenReturn(mockPatchedTvShow);

        tvShowController.patchTvShowName(TV_SHOW_ID, mockGivenTvShow);

        verify(tvShowService, times(1)).patchTvShowName(anyLong(), any());

        mockMvc.perform(patch(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
                .content(objectWriter.writeValueAsString(mockGivenTvShow))).andExpect(
                status().isOk());
    }

    @Test
    public void deleteTvShow() throws Exception {
        final String URL = RestConstants.RESOURCE_TV_SHOW + "/" + TV_SHOW_ID;

        when(tvShowService.deleteById(anyLong())).thenReturn(new TvShowRest());

        tvShowService.deleteById(TV_SHOW_ID);

        mockMvc.perform(delete(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + URL))
               .andExpect(status().isNoContent());
    }

    @Test
    public void getAwardsByTvShowId() throws Exception {
        final String URL =
                RestConstants.RESOURCE_TV_SHOW + "/" + TV_SHOW_ID + RestConstants.RESOURCE_AWARDS;

        AwardRest mockFirstAward = new AwardRest();
        mockFirstAward.setId(1L);
        mockFirstAward.setName(FIRST_AWARD_NAME);
        AwardRest mockSecondAward = new AwardRest();
        mockSecondAward.setId(2L);
        mockSecondAward.setName(SECOND_AWARD_NAME);
        List<AwardRest> mockAwards = new ArrayList<>();
        mockAwards.add(mockFirstAward);
        mockAwards.add(mockSecondAward);

        when(awardService.getAwardsByTvShowId(anyLong())).thenReturn(mockAwards);

        awardService.getAwardsByTvShowId(TV_SHOW_ID);

        verify(awardService, times(1)).getAwardsByTvShowId(anyLong());

        mockMvc.perform(get(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + URL))
               .andExpect(status().isOk());

    }
}
