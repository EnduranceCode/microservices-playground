package com.everis.d4i.tutorial.services;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.TvShowRest;
import java.util.List;

public interface TvShowService {

	List<TvShowRest> getTvShowsByCategory(Long categoryId) throws NetflixException;

	TvShowRest getTvShowById(Long id) throws NetflixException;

	TvShowRest patchTvShowName(Long id, TvShowRest tvShowRest) throws NetflixException;

	TvShowRest deleteById(Long id) throws NetflixException;
}
