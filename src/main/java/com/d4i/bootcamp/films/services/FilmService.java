package com.d4i.bootcamp.films.services;

import com.d4i.bootcamp.films.dto.FilmDto;
import java.util.List;

public interface FilmService {

    List<FilmDto> getFilmsByCategory(Long categoryId);
}
