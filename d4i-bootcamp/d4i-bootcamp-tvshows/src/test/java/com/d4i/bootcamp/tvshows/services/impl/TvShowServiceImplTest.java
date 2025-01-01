package com.d4i.bootcamp.tvshows.services.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.d4i.bootcamp.tvshows.json.TvShowRest;
import com.d4i.bootcamp.tvshows.entities.Award;
import com.d4i.bootcamp.tvshows.entities.Category;
import com.d4i.bootcamp.tvshows.entities.Chapter;
import com.d4i.bootcamp.tvshows.entities.TvShow;
import com.d4i.bootcamp.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.repositories.AwardRepository;
import com.d4i.bootcamp.tvshows.repositories.ChapterRepository;
import com.d4i.bootcamp.tvshows.repositories.TvShowRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TvShowServiceImplTest {

    @InjectMocks
    TvShowServiceImpl tvShowService;

    @Mock
    AwardRepository awardRepository;

    @Mock
    ChapterRepository chapterRepository;

    @Mock
    TvShowRepository tvShowRepository;

    static final Long CATEGORY_ID = 1L;
    static final Long TV_SHOW_ID = 1L;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTvShowsByCategory() throws D4iBootcampException {
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

    @Test
    public void patchTvShowName() throws D4iBootcampException {
        final String OLD_NAME = "Old tv show name";
        final String NEW_NAME = "New tv show name";

        TvShowRest mockGivenTvShow = new TvShowRest();
        mockGivenTvShow.setName(NEW_NAME);

        TvShow mockExistingTvShow = new TvShow();
        mockExistingTvShow.setName(OLD_NAME);

        TvShow mockPatchedTvShow = new TvShow();
        mockPatchedTvShow.setName(NEW_NAME);

        ArgumentCaptor<TvShow> tvShowCaptor = ArgumentCaptor.forClass(TvShow.class);

        when(tvShowRepository.getOne(anyLong())).thenReturn(mockExistingTvShow);
        when(tvShowRepository.save(tvShowCaptor.capture())).thenReturn(mockPatchedTvShow);

        TvShowRest tvShowRest = tvShowService.patchTvShowName(TV_SHOW_ID, mockGivenTvShow);

        verify(tvShowRepository, times(1)).getOne(anyLong());
        verify(tvShowRepository, times(1)).save(any());
        assertEquals(mockGivenTvShow.getName(), tvShowCaptor.getValue().getName());
        assertEquals(mockGivenTvShow.getName(), tvShowRest.getName());
    }

    @Test
    public void deleteById() throws D4iBootcampException {
        List<Award> mockAwards = new ArrayList<>();
        List<Chapter> mockChapters = new ArrayList<>();
        TvShow mockTvShow = new TvShow();
        mockTvShow.setAwards(mockAwards);

        when((awardRepository.getAwardsByTvShowId(anyLong()))).thenReturn(mockAwards);
        when(chapterRepository.findBySeasonTvShowId(anyLong())).thenReturn(mockChapters);
        when(tvShowRepository.getOne(anyLong())).thenReturn(mockTvShow);

        tvShowService.deleteById(TV_SHOW_ID);

        verify(tvShowRepository, times(1)).deleteById(anyLong());
    }
}
