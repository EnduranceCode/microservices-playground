package com.everis.d4i.tutorial.services.impl;

import com.everis.d4i.tutorial.json.AwardRest;
import com.everis.d4i.tutorial.repositories.AwardRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AwardServiceImpl implements com.everis.d4i.tutorial.services.AwardService {

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
