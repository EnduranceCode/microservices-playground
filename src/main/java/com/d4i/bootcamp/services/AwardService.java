package com.d4i.bootcamp.services;

import com.d4i.bootcamp.json.AwardRest;
import java.util.List;

public interface AwardService {

    List<AwardRest> getAwardsByTvShowId(Long tvShowId);
}
