package com.everis.d4i.tutorial.services.impl;

import com.everis.d4i.tutorial.entities.Season;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.SeasonRest;
import com.everis.d4i.tutorial.repositories.SeasonRepository;
import com.everis.d4i.tutorial.services.SeasonService;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;
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
	public List<SeasonRest> getSeasonsByTvShow(Long tvShowId) throws NetflixException {
		return seasonRepository.findByTvShowId(tvShowId).stream()
							   .map(season -> modelMapper.map(season, SeasonRest.class))
							   .collect(Collectors.toList());
	}

	@Override
	public List<SeasonRest> getSeasonsByActorId(Long actorId) throws NetflixException {

		return seasonRepository.getSeasonsByActorId(actorId).stream()
							   .map(season -> modelMapper.map(season, SeasonRest.class))
							   .collect(Collectors.toList());
	}

	@Override
	public SeasonRest getSeasonByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber)
			throws NetflixException {
		Season season = seasonRepository.findByTvShowIdAndNumber(tvShowId, seasonNumber)
										.orElseThrow(() -> new NotFoundException(
												ExceptionConstants.MESSAGE_INEXISTENT_SEASON));
		return modelMapper.map(season, SeasonRest.class);
	}
}
