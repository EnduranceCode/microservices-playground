package com.d4i.bootcamp.tvshows.tvshows.controllers;

import com.d4i.bootcamp.tvshows.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.tvshows.json.SeasonRest;
import com.d4i.bootcamp.tvshows.tvshows.responses.D4iBootcampResponse;
import java.util.List;

public interface SeasonController {

	D4iBootcampResponse<List<SeasonRest>> getSeasonsByTvShow(Long tvShowId)
			throws D4iBootcampException;

	D4iBootcampResponse<SeasonRest> getSeasonByTvShowIdAndSeasonNumber(Long tvShowId,
			short seasonNumber) throws D4iBootcampException;

}
