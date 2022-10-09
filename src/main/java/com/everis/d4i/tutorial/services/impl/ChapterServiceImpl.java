package com.everis.d4i.tutorial.services.impl;

import com.everis.d4i.tutorial.entities.Chapter;
import com.everis.d4i.tutorial.exceptions.InternalServerErrorException;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.ChapterRest;
import com.everis.d4i.tutorial.repositories.ChapterRepository;
import com.everis.d4i.tutorial.services.ChapterService;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChapterServiceImpl implements ChapterService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChapterServiceImpl.class);

	private final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private ChapterRepository chapterRepository;

	@Override
	public List<ChapterRest> getChaptersByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber)
			throws NetflixException {

		return chapterRepository.findBySeasonTvShowIdAndSeasonNumber(tvShowId, seasonNumber)
								.stream()
								.map(chapter -> modelMapper.map(chapter, ChapterRest.class))
								.collect(Collectors.toList());
	}

	@Override
	public ChapterRest getChapterByTvShowIdAndSeasonNumberAndChapterNumber(Long tvShowId, short seasonNumber,
			short chapterNumber) throws NetflixException {
		Chapter chapter = chapterRepository
				.findBySeasonTvShowIdAndSeasonNumberAndNumber(tvShowId, seasonNumber, chapterNumber)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER));
		return modelMapper.map(chapter, ChapterRest.class);
	}

	@Override
	public ChapterRest patchChapterName(Long tvShowId, short seasonNumber, Long chapterId,
			ChapterRest chapterRest) throws NetflixException {

		Chapter chapter;
		try {
			chapter = chapterRepository.findBySeasonTvShowIdAndSeasonNumberAndId(tvShowId,
					seasonNumber, chapterId).orElseThrow(
					() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER));
		} catch (EntityNotFoundException entityNotFoundException) {
			throw new NotFoundException(entityNotFoundException.getMessage());
		}

		chapter.setName(chapterRest.getName());

		try {
			chapter = chapterRepository.save(chapter);
		} catch (Exception e) {
			LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
			throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
		}

		return modelMapper.map(chapter, ChapterRest.class);
	}

	@Override
	public List<ChapterRest> getChaptersByActorId(Long actorId) throws NetflixException {

		return chapterRepository.getChaptersByActorId(actorId).stream()
								.map(chapter -> modelMapper.map(chapter, ChapterRest.class))
								.collect(Collectors.toList());
	}
}
