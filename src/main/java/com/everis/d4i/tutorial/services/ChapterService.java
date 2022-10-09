package com.everis.d4i.tutorial.services;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ChapterRest;
import java.util.List;

public interface ChapterService {

	List<ChapterRest> getChaptersByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber)
			throws NetflixException;

	ChapterRest getChapterByTvShowIdAndSeasonNumberAndChapterNumber(Long tvShowId,
			short seasonNumber, short chapterNumber) throws NetflixException;

	ChapterRest patchChapterName(Long tvShowId, short seasonNumber, Long chapterId,
			ChapterRest chapterRest) throws NetflixException;

	List<ChapterRest> getChaptersByActorId(Long actorId) throws NetflixException;
}
