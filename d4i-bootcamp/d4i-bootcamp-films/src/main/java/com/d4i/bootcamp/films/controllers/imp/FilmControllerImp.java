package com.d4i.bootcamp.films.controllers.imp;

import com.d4i.bootcamp.films.controllers.FilmController;
import com.d4i.bootcamp.films.dto.FilmDto;
import com.d4i.bootcamp.films.exceptions.D4iBootcampException;
import com.d4i.bootcamp.films.responses.D4iBootcampResponse;
import com.d4i.bootcamp.films.services.FilmService;
import com.d4i.bootcamp.films.utils.constants.CommonConstants;
import com.d4i.bootcamp.films.utils.constants.RestConstants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_FILM)
public class FilmControllerImp implements FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmControllerImp(FilmService filmService) {
        this.filmService = filmService;
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public D4iBootcampResponse<List<FilmDto>> getFilmsByCategory(@RequestParam Long categoryId)
            throws D4iBootcampException {

        return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                CommonConstants.OK, filmService.getFilmsByCategory(categoryId));
    }
}
