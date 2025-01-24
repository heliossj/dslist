package com.heliossj.dslist.controllers;

import com.heliossj.dslist.dto.GameDto;
import com.heliossj.dslist.dto.GameMinDto;
import com.heliossj.dslist.entities.Game;
import com.heliossj.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDto> findAll(){
        List<GameMinDto> result = gameService.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public GameDto findById(@PathVariable Long id){
        GameDto result = gameService.findById(id);
        return result;
    }
}
