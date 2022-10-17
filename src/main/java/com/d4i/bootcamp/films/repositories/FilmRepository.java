package com.d4i.bootcamp.films.repositories;

import com.d4i.bootcamp.films.entities.Film;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findByCategoryId(Long categoryId);
}
