package com.d4i.bootcamp.tvshows.services;

import com.d4i.bootcamp.tvshows.json.AwardRest;
import java.util.List;

public interface AwardService {

    List<AwardRest> getAwardsByTvShowId(Long tvShowId);
}
