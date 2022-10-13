package com.d4i.bootcamp.tvshows.tvshows.controllers;

import com.d4i.bootcamp.tvshows.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.tvshows.json.ChapterRest;
import com.d4i.bootcamp.tvshows.tvshows.responses.D4iBootcampResponse;
import java.util.List;

public interface ChapterController {

	D4iBootcampResponse<List<ChapterRest>> getChaptersByTvShowIdAndSeasonNumber(Long tvShowId,
			short seasonNumber) throws D4iBootcampException;

	D4iBootcampResponse<ChapterRest> getChapterByTvShowIdAndSeasonNumberAndChapterNumber(
			Long tvShowId, short seasonNumber, short chapterNumber) throws D4iBootcampException;

	D4iBootcampResponse<ChapterRest> patchChapterName(Long tvShowId, short seasonNumber, Long id,
			ChapterRest chapterRest) throws D4iBootcampException;
}
