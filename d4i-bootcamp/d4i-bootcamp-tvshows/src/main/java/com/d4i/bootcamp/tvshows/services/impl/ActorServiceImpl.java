package com.d4i.bootcamp.tvshows.services.impl;

import com.d4i.bootcamp.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.exceptions.InternalServerErrorException;
import com.d4i.bootcamp.tvshows.exceptions.NotFoundException;
import com.d4i.bootcamp.tvshows.json.ActorRest;
import com.d4i.bootcamp.tvshows.json.ChapterRest;
import com.d4i.bootcamp.tvshows.repositories.ActorRepository;
import com.d4i.bootcamp.tvshows.repositories.ChapterRepository;
import com.d4i.bootcamp.tvshows.entities.Actor;
import com.d4i.bootcamp.tvshows.entities.Chapter;
import com.d4i.bootcamp.tvshows.services.ActorService;
import com.d4i.bootcamp.tvshows.utils.constants.ExceptionConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActorServiceImpl.class);

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ChapterRepository chapterRepository;

    @Override
    public List<ActorRest> getActors() throws D4iBootcampException {

        return actorRepository.findAll().stream()
                              .map(actor -> modelMapper.map(actor, ActorRest.class))
                              .collect(Collectors.toList());
    }

    @Override
    public ActorRest getActorById(Long actorId) throws D4iBootcampException {
        try {
            return modelMapper.map(actorRepository.getOne(actorId), ActorRest.class);
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new NotFoundException(entityNotFoundException.getMessage());
        }
    }

    @Override
    public ActorRest createActor(ActorRest actorRest) throws D4iBootcampException {
        Actor actor = new Actor();
        actor.setName(actorRest.getName());

        addChapters(actorRest, actor);

        actor = saveActor(actor);

        return modelMapper.map(actor, ActorRest.class);
    }

    @Override
    public ActorRest updateActor(Long actorId, ActorRest actorRest) throws D4iBootcampException {
        Actor actor;
        try {
            actor = actorRepository.getOne(actorId);
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new NotFoundException(entityNotFoundException.getMessage());
        }
        actor.setName(actorRest.getName());

        addChapters(actorRest, actor);

        actor = saveActor(actor);

        return modelMapper.map(actor, ActorRest.class);
    }

    @Override
    public ActorRest deleteById(Long actorId) throws D4iBootcampException {
        try {
            actorRepository.deleteById(actorId);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TV_SHOW);
        } catch (Exception e) {
            LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
            throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
        }

        return modelMapper.map(new ActorRest(), ActorRest.class);
    }

    private void addChapters(ActorRest actorRest, Actor actor) throws NotFoundException {
        if (actorRest.getChapters() != null) {
            List<Chapter> chapters = new ArrayList<>();

            for (ChapterRest chapterRest : actorRest.getChapters()) {
                if (chapterRest.getId() != null) {
                    try {
                        chapters.add(chapterRepository.getOne(chapterRest.getId()));
                    } catch (EntityNotFoundException entityNotFoundException) {
                        throw new NotFoundException(entityNotFoundException.getMessage());
                    }
                } else {
                    throw new HttpMessageNotReadableException(
                            ExceptionConstants.MESSAGE_MALFORMED_CHAPTER);
                }
            }

            actor.setChapters(chapters);
        }
    }

    private Actor saveActor(Actor actor) throws InternalServerErrorException {
        try {
            actor = actorRepository.save(actor);
        } catch (final Exception e) {
            LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
            throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
        }

        return actor;
    }
}
