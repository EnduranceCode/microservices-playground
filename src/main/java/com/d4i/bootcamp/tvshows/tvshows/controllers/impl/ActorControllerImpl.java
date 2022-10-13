package com.d4i.bootcamp.tvshows.tvshows.controllers.impl;

import com.d4i.bootcamp.tvshows.tvshows.controllers.ActorController;
import com.d4i.bootcamp.tvshows.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.tvshows.json.ActorRest;
import com.d4i.bootcamp.tvshows.tvshows.json.ChapterRest;
import com.d4i.bootcamp.tvshows.tvshows.json.SeasonRest;
import com.d4i.bootcamp.tvshows.tvshows.responses.D4iBootcampResponse;
import com.d4i.bootcamp.tvshows.tvshows.services.ActorService;
import com.d4i.bootcamp.tvshows.tvshows.services.ChapterService;
import com.d4i.bootcamp.tvshows.tvshows.services.SeasonService;
import com.d4i.bootcamp.tvshows.tvshows.utils.constants.CommonConstants;
import com.d4i.bootcamp.tvshows.tvshows.utils.constants.RestConstants;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_ACTOR)
public class ActorControllerImpl implements ActorController {

    @Autowired
    private ActorService actorService;

    @Autowired
    ChapterService chapterService;

    @Autowired
    SeasonService seasonService;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public D4iBootcampResponse<List<ActorRest>> getActors() throws D4iBootcampException {

        return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                CommonConstants.OK, actorService.getActors());
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = RestConstants.RESOURCE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public D4iBootcampResponse<ActorRest> getActorById(@PathVariable Long id)
            throws D4iBootcampException {

        return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                CommonConstants.OK, actorService.getActorById(id));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public D4iBootcampResponse<ActorRest> createActor(
            @ApiParam(value = RestConstants.PARAMETER_ACTOR, required = true) @RequestBody @Valid final ActorRest actorRest)
            throws D4iBootcampException {

        return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                CommonConstants.OK, actorService.createActor(actorRest));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = RestConstants.RESOURCE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public D4iBootcampResponse<ActorRest> updateActor(@PathVariable Long id,
            @ApiParam(value = RestConstants.PARAMETER_ACTOR, required = true) @RequestBody @Valid final ActorRest actorRest)
            throws D4iBootcampException {

        return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                CommonConstants.OK, actorService.updateActor(id, actorRest));
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = RestConstants.RESOURCE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public D4iBootcampResponse<ActorRest> deleteActorById(@PathVariable Long id)
            throws D4iBootcampException {

        return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                CommonConstants.OK, actorService.deleteById(id));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = RestConstants.RESOURCE_ACTOR_SEASON, produces = MediaType.APPLICATION_JSON_VALUE)
    public D4iBootcampResponse<List<SeasonRest>> getSeasonsByActorId(@PathVariable Long id)
            throws D4iBootcampException {

        return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                CommonConstants.OK, seasonService.getSeasonsByActorId(id));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = RestConstants.RESOURCE_ACTOR_CHAPTER, produces = MediaType.APPLICATION_JSON_VALUE)
    public D4iBootcampResponse<List<ChapterRest>> getChaptersByActorId(@PathVariable Long id)
            throws D4iBootcampException {

        return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                CommonConstants.OK, chapterService.getChaptersByActorId(id));
    }
}
