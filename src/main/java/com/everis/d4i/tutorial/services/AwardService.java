package com.everis.d4i.tutorial.services;

import com.everis.d4i.tutorial.json.AwardRest;
import java.util.List;

public interface AwardService {

    List<AwardRest> getAwardsByTvShowId(Long tvShowId);
}
