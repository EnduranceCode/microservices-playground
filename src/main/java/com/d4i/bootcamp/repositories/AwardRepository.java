package com.d4i.bootcamp.repositories;

import com.d4i.bootcamp.entities.Award;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardRepository extends JpaRepository<Award, Long> {

    List<Award> getAwardsByTvShowId(Long tvShowId);
}
