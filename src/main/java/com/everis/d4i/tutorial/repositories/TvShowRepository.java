package com.everis.d4i.tutorial.repositories;

import com.everis.d4i.tutorial.entities.TvShow;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvShowRepository extends JpaRepository<TvShow, Long> {

	List<TvShow> findByCategoryId(Long categoryId);

}
