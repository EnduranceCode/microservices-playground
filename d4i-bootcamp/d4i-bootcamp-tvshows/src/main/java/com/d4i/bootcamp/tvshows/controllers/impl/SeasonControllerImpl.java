package com.d4i.bootcamp.tvshows.controllers.impl;

import com.d4i.bootcamp.tvshows.json.SeasonRest;
import com.d4i.bootcamp.tvshows.controllers.SeasonController;
import com.d4i.bootcamp.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.responses.D4iBootcampResponse;
import com.d4i.bootcamp.tvshows.services.SeasonService;
import com.d4i.bootcamp.tvshows.utils.constants.CommonConstants;
import com.d4i.bootcamp.tvshows.utils.constants.RestConstants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_SEASON)
public class SeasonControllerImpl implements SeasonController {

	@Autowired
	private SeasonService seasonService;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public D4iBootcampResponse<List<SeasonRest>> getSeasonsByTvShow(@PathVariable Long tvShowId)
			throws D4iBootcampException {

		return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, seasonService.getSeasonsByTvShow(tvShowId));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = RestConstants.RESOURCE_NUMBER, produces = MediaType.APPLICATION_JSON_VALUE)
	public D4iBootcampResponse<SeasonRest> getSeasonByTvShowIdAndSeasonNumber(
			@PathVariable Long tvShowId, @PathVariable short number) throws D4iBootcampException {

		return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK,
				seasonService.getSeasonByTvShowIdAndSeasonNumber(tvShowId, number));
	}
}
