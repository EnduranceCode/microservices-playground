package com.everis.d4i.tutorial.repositories;

import com.everis.d4i.tutorial.entities.Chapter;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {

	List<Chapter> findBySeasonTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber);

	Optional<Chapter> findBySeasonTvShowIdAndSeasonNumberAndNumber(Long tvShowId,
			short seasonNumber, short chapterNumber);

	Optional<Chapter> findBySeasonTvShowIdAndSeasonNumberAndId(Long tvShowId, short seasonNumber,
			Long chapterId);

	List<Chapter> getChaptersByActorId(Long actorId);
}
