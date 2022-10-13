package com.d4i.bootcamp.tvshows.tvshows.services;

import com.d4i.bootcamp.tvshows.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.tvshows.json.SeasonRest;
import java.util.List;

public interface SeasonService {

	List<SeasonRest> getSeasonsByTvShow(Long tvShowId) throws D4iBootcampException;

	List<SeasonRest> getSeasonsByActorId(Long actorId) throws D4iBootcampException;

	SeasonRest getSeasonByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber)
			throws D4iBootcampException;
}
