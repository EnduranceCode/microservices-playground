package com.d4i.bootcamp.films.controllers;

import com.d4i.bootcamp.films.dto.FilmDto;
import com.d4i.bootcamp.films.exceptions.D4iBootcampException;
import com.d4i.bootcamp.films.responses.D4iBootcampResponse;
import java.util.List;

public interface FilmController {

    D4iBootcampResponse<List<FilmDto>> getFilmsByCategory(Long categoryId)
            throws D4iBootcampException;
}
