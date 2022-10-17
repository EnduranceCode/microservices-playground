package com.d4i.bootcamp.films.services.imp;

import com.d4i.bootcamp.films.dto.FilmDto;
import com.d4i.bootcamp.films.repositories.FilmRepository;
import com.d4i.bootcamp.films.services.FilmService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImp implements FilmService {

    private final FilmRepository filmRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public FilmServiceImp(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public List<FilmDto> getFilmsByCategory(Long categoryId) {

        return filmRepository.findByCategoryId(categoryId).stream()
                             .map(film -> modelMapper.map(film, FilmDto.class))
                             .collect(Collectors.toList());
    }
}
