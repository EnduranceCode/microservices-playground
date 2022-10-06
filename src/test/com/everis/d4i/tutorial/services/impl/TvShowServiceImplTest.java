package com.everis.d4i.tutorial.services.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.everis.d4i.tutorial.entities.Category;
import com.everis.d4i.tutorial.entities.TvShow;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.TvShowRest;
import com.everis.d4i.tutorial.repositories.TvShowRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TvShowServiceImplTest {

    @InjectMocks
    TvShowServiceImpl tvShowService;

    @Mock
    TvShowRepository tvShowRepository;

    static Long CATEGORY_ID;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        CATEGORY_ID = 1L;
    }

    @Test
    public void getTvShowsByCategory() throws NetflixException {
        Category mockCategory = new Category();
        mockCategory.setId(CATEGORY_ID);
        List<Category> mockCategories = new ArrayList<>();
        mockCategories.add(mockCategory);

        TvShow mockTvShow = new TvShow();
        mockTvShow.setCategories(mockCategories);

        List<TvShow> mockTvShows = new ArrayList<>();
        mockTvShows.add(mockTvShow);

        when(tvShowRepository.findByCategoryId(anyLong())).thenReturn(mockTvShows);

        List<TvShowRest> tvShows = tvShowService.getTvShowsByCategory(CATEGORY_ID);

        verify(tvShowRepository, times(1)).findByCategoryId(anyLong());
        assertEquals(CATEGORY_ID, tvShows.get(0).getCategories().get(0).getId());
    }
}
