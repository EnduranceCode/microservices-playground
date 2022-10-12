package com.d4i.bootcamp.controllers;

import com.d4i.bootcamp.exceptions.D4iBootcampException;
import com.d4i.bootcamp.json.AwardRest;
import com.d4i.bootcamp.json.TvShowRest;
import com.d4i.bootcamp.responses.D4iBootcampResponse;
import java.util.List;

public interface TvShowController {

	D4iBootcampResponse<List<TvShowRest>> getTvShowsByCategory(Long categoryId)
			throws D4iBootcampException;

	D4iBootcampResponse<TvShowRest> getTvShowById(Long id) throws D4iBootcampException;

	D4iBootcampResponse<List<AwardRest>> getAwardsByTvShowId(Long id) throws D4iBootcampException;

	D4iBootcampResponse<TvShowRest> patchTvShowName(Long id, TvShowRest tvShowRest)
			throws D4iBootcampException;

	D4iBootcampResponse<TvShowRest> deleteTvShow(Long id) throws D4iBootcampException;
}
