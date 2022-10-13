package com.d4i.bootcamp.tvshows.tvshows.controllers.impl;

import com.d4i.bootcamp.tvshows.tvshows.controllers.TvShowController;
import com.d4i.bootcamp.tvshows.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.tvshows.json.AwardRest;
import com.d4i.bootcamp.tvshows.tvshows.json.TvShowRest;
import com.d4i.bootcamp.tvshows.tvshows.responses.D4iBootcampResponse;
import com.d4i.bootcamp.tvshows.tvshows.services.AwardService;
import com.d4i.bootcamp.tvshows.tvshows.services.TvShowService;
import com.d4i.bootcamp.tvshows.tvshows.utils.constants.CommonConstants;
import com.d4i.bootcamp.tvshows.tvshows.utils.constants.RestConstants;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1
		+ RestConstants.RESOURCE_TV_SHOW)
public class TvShowControllerImpl implements TvShowController {

	@Autowired
	private AwardService awardService;

	@Autowired
	private TvShowService tvShowService;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public D4iBootcampResponse<List<TvShowRest>> getTvShowsByCategory(@RequestParam Long categoryId)
			throws D4iBootcampException {

		return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, tvShowService.getTvShowsByCategory(categoryId));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = RestConstants.RESOURCE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public D4iBootcampResponse<TvShowRest> getTvShowById(@PathVariable Long id)
			throws D4iBootcampException {

		return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, tvShowService.getTvShowById(id));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = RestConstants.RESOURCE_ID
			+ RestConstants.RESOURCE_AWARDS, produces = MediaType.APPLICATION_JSON_VALUE)
	public D4iBootcampResponse<List<AwardRest>> getAwardsByTvShowId(@PathVariable Long id)
			throws D4iBootcampException {

		return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, awardService.getAwardsByTvShowId(id));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@PatchMapping(value = RestConstants.RESOURCE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public D4iBootcampResponse<TvShowRest> patchTvShowName(@PathVariable Long id,
			@ApiParam(value = RestConstants.PARAMETER_TV_SHOW, required = true) @RequestBody @Valid final TvShowRest tvShowRest)
			throws D4iBootcampException {

		return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, tvShowService.patchTvShowName(id, tvShowRest));
	}

	@Override
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = RestConstants.RESOURCE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public D4iBootcampResponse<TvShowRest> deleteTvShow(@PathVariable Long id)
			throws D4iBootcampException {

		return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, tvShowService.deleteById(id));
	}
}
