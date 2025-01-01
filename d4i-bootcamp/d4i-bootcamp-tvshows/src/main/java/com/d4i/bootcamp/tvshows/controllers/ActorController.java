package com.d4i.bootcamp.tvshows.controllers;

import com.d4i.bootcamp.tvshows.json.ActorRest;
import com.d4i.bootcamp.tvshows.json.ChapterRest;
import com.d4i.bootcamp.tvshows.json.SeasonRest;
import com.d4i.bootcamp.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.responses.D4iBootcampResponse;
import java.util.List;

public interface ActorController {

    D4iBootcampResponse<List<ActorRest>> getActors() throws D4iBootcampException;

    D4iBootcampResponse<ActorRest> getActorById(Long id) throws D4iBootcampException;

    D4iBootcampResponse<ActorRest> createActor(ActorRest actorRest) throws D4iBootcampException;

    D4iBootcampResponse<ActorRest> updateActor(Long id, ActorRest actorRest)
            throws D4iBootcampException;

    D4iBootcampResponse<ActorRest> deleteActorById(Long id) throws D4iBootcampException;

    D4iBootcampResponse<List<SeasonRest>> getSeasonsByActorId(Long id) throws D4iBootcampException;

    D4iBootcampResponse<List<ChapterRest>> getChaptersByActorId(Long id)
            throws D4iBootcampException;
}
