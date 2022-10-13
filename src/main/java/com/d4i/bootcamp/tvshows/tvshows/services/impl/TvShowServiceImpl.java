package com.d4i.bootcamp.tvshows.tvshows.services.impl;

import com.d4i.bootcamp.tvshows.tvshows.entities.Actor;
import com.d4i.bootcamp.tvshows.tvshows.entities.Award;
import com.d4i.bootcamp.tvshows.tvshows.entities.Chapter;
import com.d4i.bootcamp.tvshows.tvshows.entities.TvShow;
import com.d4i.bootcamp.tvshows.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.tvshows.exceptions.InternalServerErrorException;
import com.d4i.bootcamp.tvshows.tvshows.exceptions.NotFoundException;
import com.d4i.bootcamp.tvshows.tvshows.json.TvShowRest;
import com.d4i.bootcamp.tvshows.tvshows.repositories.AwardRepository;
import com.d4i.bootcamp.tvshows.tvshows.repositories.ChapterRepository;
import com.d4i.bootcamp.tvshows.tvshows.repositories.TvShowRepository;
import com.d4i.bootcamp.tvshows.tvshows.services.TvShowService;
import com.d4i.bootcamp.tvshows.tvshows.utils.constants.ExceptionConstants;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TvShowServiceImpl implements TvShowService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TvShowServiceImpl.class);

	private final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private AwardRepository awardRepository;

	@Autowired
	private ChapterRepository chapterRepository;

	@Autowired
	private TvShowRepository tvShowRepository;

	@Override
	public List<TvShowRest> getTvShowsByCategory(Long categoryId) throws D4iBootcampException {

		return tvShowRepository.findByCategoryId(categoryId).stream()
							   .map(tvShow -> modelMapper.map(tvShow, TvShowRest.class))
							   .collect(Collectors.toList());

	}

	@Override
	public TvShowRest getTvShowById(Long id) throws D4iBootcampException {

		try {
			return modelMapper.map(tvShowRepository.getOne(id), TvShowRest.class);
		} catch (EntityNotFoundException entityNotFoundException) {
			throw new NotFoundException(entityNotFoundException.getMessage());
		}

	}

	@Override
	public TvShowRest patchTvShowName(Long tvShowId, TvShowRest tvShowRest)
			throws D4iBootcampException {

		TvShow tvShow;
		try {
			tvShow = tvShowRepository.getOne(tvShowId);
		} catch (EntityNotFoundException entityNotFoundException) {
			throw new NotFoundException(entityNotFoundException.getMessage());
		}

		tvShow.setName(tvShowRest.getName());

		try {
			tvShow = tvShowRepository.save(tvShow);
		} catch (Exception e) {
			LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
			throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
		}

		return modelMapper.map(tvShow, TvShowRest.class);
	}

	@Override
	public TvShowRest deleteById(Long id) throws D4iBootcampException {
		List<Chapter> chapters = chapterRepository.findBySeasonTvShowId(id);
		for (Chapter chapter : chapters) {
			for (Actor actor : chapter.getActors()) {
				actor.getChapters().remove(chapter);
			}
			chapter.getActors().clear();
		}

		List<Award> awards = awardRepository.getAwardsByTvShowId(id);
		for (Award award : awards) {
			award.getTvShows().removeIf(tvShow -> tvShow.getId().equals(id));
		}
		tvShowRepository.getOne(id).getAwards().clear();

		try {
			tvShowRepository.deleteById(id);
		} catch (EmptyResultDataAccessException emptyResultDataAccessException) {
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TV_SHOW);
		} catch (Exception e) {
			LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
			throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
		}

		return modelMapper.map(new TvShow(), TvShowRest.class);
	}
}
