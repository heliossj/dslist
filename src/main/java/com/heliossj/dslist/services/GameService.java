package com.heliossj.dslist.services;

import com.heliossj.dslist.dto.GameMinDto;
import com.heliossj.dslist.entities.Game;
import com.heliossj.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDto> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDto(x)).toList();
    }


}
