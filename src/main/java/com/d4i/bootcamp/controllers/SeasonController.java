package com.d4i.bootcamp.controllers;

import com.d4i.bootcamp.exceptions.D4iBootcampException;
import com.d4i.bootcamp.json.SeasonRest;
import com.d4i.bootcamp.responses.D4iBootcampResponse;
import java.util.List;

public interface SeasonController {

	D4iBootcampResponse<List<SeasonRest>> getSeasonsByTvShow(Long tvShowId)
			throws D4iBootcampException;

	D4iBootcampResponse<SeasonRest> getSeasonByTvShowIdAndSeasonNumber(Long tvShowId,
			short seasonNumber) throws D4iBootcampException;

}
