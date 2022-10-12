package com.d4i.bootcamp.controllers.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyShort;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;

import com.d4i.bootcamp.json.ChapterRest;
import com.d4i.bootcamp.utils.constants.RestConstants;
import com.d4i.bootcamp.services.ChapterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ChapterControllerImplTest {

    @InjectMocks
    ChapterControllerImpl chapterController;

    @Mock
    ChapterService chapterService;
    ObjectWriter objectWriter;

    MockMvc mockMvc;

    static final Long TV_SHOW_ID = 1L;
    static final short SEASON_NUMBER = 1;
    static final Long CHAPTER_ID = 1L;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

        mockMvc = MockMvcBuilders.standaloneSetup(chapterController).build();
    }

    @Test
    public void patchChapterName() throws Exception {
        final String OLD_NAME = "Old chapter name";
        final String NEW_NAME = "New chapter name";
        final String URL = RestConstants.RESOURCE_CHAPTER
                .replace("{tvShowId}", String.valueOf(TV_SHOW_ID))
                .replace("{seasonNumber}", String.valueOf(SEASON_NUMBER)).concat("/" + TV_SHOW_ID);

        ChapterRest mockGivenChapter = new ChapterRest();
        mockGivenChapter.setName(OLD_NAME);

        ChapterRest mockPatchedChapter = new ChapterRest();
        mockPatchedChapter.setName(NEW_NAME);

        when(chapterService.patchChapterName(anyLong(), anyShort(), anyLong(), any())).thenReturn(
                mockPatchedChapter);

        chapterController.patchChapterName(TV_SHOW_ID, SEASON_NUMBER, CHAPTER_ID, mockGivenChapter);

        verify(chapterService, times(1)).patchChapterName(anyLong(), anyShort(), anyLong(), any());

        mockMvc.perform(patch(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
                .content(objectWriter.writeValueAsString(mockGivenChapter)));
    }
}
