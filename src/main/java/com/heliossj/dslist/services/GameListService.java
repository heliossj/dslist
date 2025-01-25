package com.heliossj.dslist.services;

import com.heliossj.dslist.dto.GameListDto;
import com.heliossj.dslist.entities.GameList;
import com.heliossj.dslist.projections.GameMinProjection;
import com.heliossj.dslist.repository.GameListRepository;
import com.heliossj.dslist.repository.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public List<GameListDto> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDto(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destionationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destionationIndex, obj);

        int min = sourceIndex <  destionationIndex ? sourceIndex : destionationIndex;

        int max = sourceIndex <  destionationIndex ? destionationIndex : sourceIndex;

        for (int i = min; i <= max ; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}
