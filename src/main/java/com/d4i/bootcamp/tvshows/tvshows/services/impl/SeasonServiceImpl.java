package com.d4i.bootcamp.tvshows.tvshows.services.impl;

import com.d4i.bootcamp.tvshows.tvshows.entities.Season;
import com.d4i.bootcamp.tvshows.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.tvshows.exceptions.NotFoundException;
import com.d4i.bootcamp.tvshows.tvshows.json.SeasonRest;
import com.d4i.bootcamp.tvshows.tvshows.repositories.SeasonRepository;
import com.d4i.bootcamp.tvshows.tvshows.services.SeasonService;
import com.d4i.bootcamp.tvshows.tvshows.utils.constants.ExceptionConstants;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeasonServiceImpl implements SeasonService {

	private final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private SeasonRepository seasonRepository;

	@Override
	public List<SeasonRest> getSeasonsByTvShow(Long tvShowId) throws D4iBootcampException {
		return seasonRepository.findByTvShowId(tvShowId).stream()
							   .map(season -> modelMapper.map(season, SeasonRest.class))
							   .collect(Collectors.toList());
	}

	@Override
	public List<SeasonRest> getSeasonsByActorId(Long actorId) throws D4iBootcampException {

		return seasonRepository.getSeasonsByActorId(actorId).stream()
							   .map(season -> modelMapper.map(season, SeasonRest.class))
							   .collect(Collectors.toList());
	}

	@Override
	public SeasonRest getSeasonByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber)
			throws D4iBootcampException {
		Season season = seasonRepository.findByTvShowIdAndNumber(tvShowId, seasonNumber)
										.orElseThrow(() -> new NotFoundException(
												ExceptionConstants.MESSAGE_INEXISTENT_SEASON));
		return modelMapper.map(season, SeasonRest.class);
	}
}
