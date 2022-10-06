package com.everis.d4i.tutorial.controllers.impl;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.everis.d4i.tutorial.json.CategoryRest;
import com.everis.d4i.tutorial.json.TvShowRest;
import com.everis.d4i.tutorial.services.TvShowService;
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

public class TvShowControllerImplTest {

    @InjectMocks
    TvShowControllerImpl tvShowController;

    @Mock
    TvShowService tvShowService;

    MockMvc mockMvc;

    static Long CATEGORY_ID;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(tvShowController).build();

        CATEGORY_ID = 1L;
    }

    @Test
    public void getTvShowsByCategory() throws Exception {
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

        mockMvc.perform(get(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1
                                    + RestConstants.RESOURCE_TV_SHOW + "?categoryId="
                                    + CATEGORY_ID)).andExpect(status().isOk());
    }
}
