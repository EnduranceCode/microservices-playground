package com.everis.d4i.tutorial.services;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ActorRest;
import java.util.List;

public interface ActorService {

    List<ActorRest> getActors();

    ActorRest getActorById(Long actorId) throws NetflixException;

    ActorRest createActor(ActorRest actorRest) throws NetflixException;
}
