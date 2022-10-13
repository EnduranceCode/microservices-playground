package com.d4i.bootcamp.tvshows.tvshows.services;

import com.d4i.bootcamp.tvshows.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.tvshows.json.ActorRest;
import java.util.List;

public interface ActorService {

    List<ActorRest> getActors() throws D4iBootcampException;

    ActorRest getActorById(Long actorId) throws D4iBootcampException;

    ActorRest createActor(ActorRest actorRest) throws D4iBootcampException;

    ActorRest updateActor(Long actorId, ActorRest actorRest) throws D4iBootcampException;

    ActorRest deleteById(Long actorId) throws D4iBootcampException;
}
