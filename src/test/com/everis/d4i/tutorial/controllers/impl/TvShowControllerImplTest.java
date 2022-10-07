package com.everis.d4i.tutorial.controllers.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.everis.d4i.tutorial.json.CategoryRest;
import com.everis.d4i.tutorial.json.TvShowRest;
import com.everis.d4i.tutorial.services.TvShowService;
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

public class TvShowControllerImplTest {

    @InjectMocks
    TvShowControllerImpl tvShowController;

    @Mock
    TvShowService tvShowService;

    ObjectWriter objectWriter;

    MockMvc mockMvc;

    static final Long CATEGORY_ID = 1L;
    static final Long TV_SHOW_ID = 1L;

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
        final String URL = RestConstants.RESOURCE_TV_SHOW + "/" + CATEGORY_ID;

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
}
