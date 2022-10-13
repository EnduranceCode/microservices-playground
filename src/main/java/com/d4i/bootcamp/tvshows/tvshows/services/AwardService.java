package com.d4i.bootcamp.tvshows.tvshows.services;

import com.d4i.bootcamp.tvshows.tvshows.json.AwardRest;
import java.util.List;

public interface AwardService {

    List<AwardRest> getAwardsByTvShowId(Long tvShowId);
}
