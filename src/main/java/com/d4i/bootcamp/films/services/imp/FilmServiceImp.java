package com.d4i.bootcamp.films.services.imp;

import com.d4i.bootcamp.films.dto.CategoryDto;
import com.d4i.bootcamp.films.dto.FilmDto;
import com.d4i.bootcamp.films.entities.Film;
import com.d4i.bootcamp.films.exceptions.D4iBootcampException;
import com.d4i.bootcamp.films.exceptions.InternalServerErrorException;
import com.d4i.bootcamp.films.repositories.FilmRepository;
import com.d4i.bootcamp.films.services.FilmService;
import com.d4i.bootcamp.films.utils.constants.RestConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class FilmServiceImp implements FilmService {

    private final FilmRepository filmRepository;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper jsonMapper = new ObjectMapper();

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public FilmServiceImp(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public List<FilmDto> getFilmsByCategory(Long categoryId) throws D4iBootcampException {

        List<CategoryDto> categories = getCategoriesFromTvShowsApi();

        List<Film> films = filmRepository.findByCategoryId(categoryId);
        List<FilmDto> filmsDto = new ArrayList<>();

        for (Film film : films) {

            FilmDto filmDto = modelMapper.map(film, FilmDto.class);

            List<CategoryDto> filmCategories = new ArrayList<>();
            for (Long id : film.getCategories()) {
                categories.stream().filter(category -> category.getId().equals(id)).findFirst()
                          .ifPresent(filmCategories::add);
            }

            filmDto.setCategories(filmCategories);
            filmsDto.add(filmDto);
        }

        return filmsDto;
    }

    private List<CategoryDto> getCategoriesFromTvShowsApi() throws D4iBootcampException {

        final String ENDPOINT =
                RestConstants.TV_SHOWS_API_BASE_URL + RestConstants.TV_SHOWS_RESOURCE_CATEGORY;

        ResponseEntity<String> response;
        try {
            response = restTemplate.getForEntity(ENDPOINT, String.class);
        } catch (RestClientException exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }

        JsonNode data;
        try {
            data = jsonMapper.readTree(response.getBody()).path("data");
        } catch (JsonProcessingException exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }

        List<CategoryDto> categories;
        try {
            ObjectReader categoryListReader = jsonMapper.readerFor(
                    new TypeReference<List<CategoryDto>>() {
                    });
            categories = categoryListReader.readValue(data);
        } catch (IOException exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }

        return categories;
    }
}
