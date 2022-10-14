package com.d4i.bootcamp.tvshows.services.impl;

import com.d4i.bootcamp.tvshows.json.AwardRest;
import com.d4i.bootcamp.tvshows.repositories.AwardRepository;
import com.d4i.bootcamp.tvshows.services.AwardService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AwardServiceImpl implements AwardService {

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private AwardRepository awardRepository;

    @Override
    public List<AwardRest> getAwardsByTvShowId(Long tvShowId) {
        return awardRepository.getAwardsByTvShowId(tvShowId).stream()
                              .map(award -> modelMapper.map(award, AwardRest.class))
                              .collect(Collectors.toList());
    }
}
