package com.d4i.bootcamp.services;

import com.d4i.bootcamp.exceptions.D4iBootcampException;
import com.d4i.bootcamp.json.ActorRest;
import java.util.List;

public interface ActorService {

    List<ActorRest> getActors() throws D4iBootcampException;

    ActorRest getActorById(Long actorId) throws D4iBootcampException;

    ActorRest createActor(ActorRest actorRest) throws D4iBootcampException;

    ActorRest updateActor(Long actorId, ActorRest actorRest) throws D4iBootcampException;

    ActorRest deleteById(Long actorId) throws D4iBootcampException;
}
