package com.everis.d4i.tutorial.services.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyShort;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.everis.d4i.tutorial.entities.Chapter;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ChapterRest;
import com.everis.d4i.tutorial.repositories.ChapterRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ChapterServiceImplTest {

    @InjectMocks
    ChapterServiceImpl chapterService;

    @Mock
    ChapterRepository chapterRepository;

    static final Long ACTOR_ID = 1L;
    static final Long TV_SHOW_ID = 1L;
    static final short SEASON_NUMBER = 1;
    static final Long CHAPTER_ID = 1L;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void patchChapterName() throws NetflixException {
        final String OLD_NAME = "Old chapter name";
        final String NEW_NAME = "New chapter name";

        ChapterRest mockGivenChapter = new ChapterRest();
        mockGivenChapter.setName(NEW_NAME);

        Chapter mockExistingChapter = new Chapter();
        mockExistingChapter.setName(OLD_NAME);

        Chapter mockPatchedChapter = new Chapter();
        mockPatchedChapter.setName(mockGivenChapter.getName());

        ArgumentCaptor<Chapter> chapterCaptor = ArgumentCaptor.forClass(Chapter.class);

        when(chapterRepository.findBySeasonTvShowIdAndSeasonNumberAndId(anyLong(), anyShort(),
                anyLong())).thenReturn(Optional.of(mockExistingChapter));
        when(chapterRepository.save(chapterCaptor.capture())).thenReturn(mockPatchedChapter);

        ChapterRest chapterRest = chapterService.patchChapterName(TV_SHOW_ID, SEASON_NUMBER,
                CHAPTER_ID, mockGivenChapter);

        verify(chapterRepository, times(1)).findBySeasonTvShowIdAndSeasonNumberAndId(anyLong(),
                anyShort(), anyLong());
        verify(chapterRepository, times(1)).save(any());
        assertEquals(mockGivenChapter.getName(), chapterCaptor.getValue().getName());
        assertEquals(mockGivenChapter.getName(), chapterRest.getName());
    }

    @Test
    public void getChaptersByActorId() throws NetflixException {
        Chapter mockFirstChapter = new Chapter();
        mockFirstChapter.setId(1L);
        mockFirstChapter.setName("Capitulo 1");

        Chapter mockSecondChapter = new Chapter();
        mockSecondChapter.setId(1L);
        mockSecondChapter.setName("Capitulo 2");

        List<Chapter> mockChapters = new ArrayList<>();
        mockChapters.add(mockFirstChapter);
        mockChapters.add(mockSecondChapter);

        when(chapterRepository.getChaptersByActorId(anyLong())).thenReturn(mockChapters);

        List<ChapterRest> chapters = chapterService.getChaptersByActorId(ACTOR_ID);

        verify(chapterRepository, times(1)).getChaptersByActorId(anyLong());

        assertEquals(mockChapters.size(), chapters.size());
    }
}
