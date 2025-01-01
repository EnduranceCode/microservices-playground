package com.d4i.bootcamp.tvshows.repositories;

import com.d4i.bootcamp.tvshows.entities.Season;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {

	List<Season> findByTvShowId(Long tvShowId);

	List<Season> getSeasonsByActorId(Long actorId);

	Optional<Season> findByTvShowIdAndNumber(Long tvShowId, short seasonNumber);

}
