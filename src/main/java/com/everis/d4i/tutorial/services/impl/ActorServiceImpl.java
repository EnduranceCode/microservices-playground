package com.everis.d4i.tutorial.services.impl;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.repositories.ActorRepository;
import com.everis.d4i.tutorial.services.ActorService;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    private final ModelMapper modelMapper = new ModelMapper();

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
}
