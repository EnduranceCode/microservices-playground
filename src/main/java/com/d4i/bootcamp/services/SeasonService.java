package com.d4i.bootcamp.services;

import com.d4i.bootcamp.exceptions.D4iBootcampException;
import com.d4i.bootcamp.json.SeasonRest;
import java.util.List;

public interface SeasonService {

	List<SeasonRest> getSeasonsByTvShow(Long tvShowId) throws D4iBootcampException;

	List<SeasonRest> getSeasonsByActorId(Long actorId) throws D4iBootcampException;

	SeasonRest getSeasonByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber)
			throws D4iBootcampException;
}
