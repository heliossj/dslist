package com.heliossj.dslist.controllers;

import com.heliossj.dslist.dto.GameDto;
import com.heliossj.dslist.dto.GameListDto;
import com.heliossj.dslist.dto.GameMinDto;
import com.heliossj.dslist.dto.ReplacementDto;
import com.heliossj.dslist.projections.GameMinProjection;
import com.heliossj.dslist.services.GameListService;
import com.heliossj.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDto> findAll(){
        List<GameListDto> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value="/{listId}/games")
    public List<GameMinDto> findByList(@PathVariable Long listId){
        List<GameMinDto> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value="/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDto body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

}
