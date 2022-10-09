package com.everis.d4i.tutorial.controllers;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.AwardRest;
import com.everis.d4i.tutorial.json.TvShowRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;
import java.util.List;

public interface TvShowController {

	NetflixResponse<List<TvShowRest>> getTvShowsByCategory(Long categoryId) throws NetflixException;

	NetflixResponse<TvShowRest> getTvShowById(Long id) throws NetflixException;

	NetflixResponse<List<AwardRest>> getAwardsByTvShowId(Long id) throws NetflixException;

	NetflixResponse<TvShowRest> patchTvShowName(Long id, TvShowRest tvShowRest)
			throws NetflixException;

	NetflixResponse<TvShowRest> deleteTvShow(Long id) throws NetflixException;
}
