package com.d4i.bootcamp.tvshows.repositories;

import com.d4i.bootcamp.tvshows.entities.TvShow;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvShowRepository extends JpaRepository<TvShow, Long> {

	List<TvShow> findByCategoryId(Long categoryId);

}
