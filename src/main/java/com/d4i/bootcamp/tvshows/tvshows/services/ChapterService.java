package com.d4i.bootcamp.tvshows.tvshows.services;

import com.d4i.bootcamp.tvshows.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.tvshows.json.ChapterRest;
import java.util.List;

public interface ChapterService {

	List<ChapterRest> getChaptersByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber)
			throws D4iBootcampException;

	ChapterRest getChapterByTvShowIdAndSeasonNumberAndChapterNumber(Long tvShowId,
			short seasonNumber, short chapterNumber) throws D4iBootcampException;

	ChapterRest patchChapterName(Long tvShowId, short seasonNumber, Long chapterId,
			ChapterRest chapterRest) throws D4iBootcampException;

	List<ChapterRest> getChaptersByActorId(Long actorId) throws D4iBootcampException;
}
