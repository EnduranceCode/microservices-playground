package com.everis.d4i.tutorial.services;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.SeasonRest;
import java.util.List;

public interface SeasonService {

	List<SeasonRest> getSeasonsByTvShow(Long tvShowId) throws NetflixException;

	List<SeasonRest> getSeasonsByActorId(Long actorId) throws NetflixException;

	SeasonRest getSeasonByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber)
			throws NetflixException;
}
