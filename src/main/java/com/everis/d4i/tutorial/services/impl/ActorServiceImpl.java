package com.everis.d4i.tutorial.services.impl;

import com.everis.d4i.tutorial.entities.Actor;
import com.everis.d4i.tutorial.entities.Chapter;
import com.everis.d4i.tutorial.exceptions.InternalServerErrorException;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.json.ChapterRest;
import com.everis.d4i.tutorial.repositories.ActorRepository;
import com.everis.d4i.tutorial.repositories.ChapterRepository;
import com.everis.d4i.tutorial.services.ActorService;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ActorRest> getActors() {

        return actorRepository.findAll().stream()
                              .map(actor -> modelMapper.map(actor, ActorRest.class))
                              .collect(Collectors.toList());
    }

    @Override
    public ActorRest getActorById(Long actorId) throws NetflixException {
        try {
            return modelMapper.map(actorRepository.getOne(actorId), ActorRest.class);
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new NotFoundException(entityNotFoundException.getMessage());
        }
    }

    @Override
    public ActorRest createActor(ActorRest actorRest) throws NetflixException {
        Actor actor = new Actor();
        actor.setName(actorRest.getName());

        if (actorRest.getChapters() != null && !actorRest.getChapters().isEmpty()) {
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
                            ExceptionConstants.MESSAGE_MALFORMED_CHAPtER);
                }
            }

            actor.setChapters(chapters);
        }

        try {
            actor = actorRepository.save(actor);
        } catch (final Exception e) {
            LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
            throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
        }

        return modelMapper.map(actor, ActorRest.class);
    }
}
