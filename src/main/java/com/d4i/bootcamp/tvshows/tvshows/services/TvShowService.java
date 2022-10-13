package com.d4i.bootcamp.tvshows.tvshows.services;

import com.d4i.bootcamp.tvshows.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.tvshows.json.TvShowRest;
import java.util.List;

public interface TvShowService {

	List<TvShowRest> getTvShowsByCategory(Long categoryId) throws D4iBootcampException;

	TvShowRest getTvShowById(Long id) throws D4iBootcampException;

	TvShowRest patchTvShowName(Long id, TvShowRest tvShowRest) throws D4iBootcampException;

	TvShowRest deleteById(Long id) throws D4iBootcampException;
}
