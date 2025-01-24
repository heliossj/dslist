package com.heliossj.dslist.repository;

import com.heliossj.dslist.entities.Game;
import com.heliossj.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
            SELECT tbgame.id, tbgame.title, tbgame.game_year AS `year`, tbgame.img_url AS imgUrl,
            		tbgame.short_description AS shortDescription, tb_belonging.position
            		FROM tbgame
            		INNER JOIN tb_belonging ON tbgame.id = tb_belonging.game_id
            		WHERE tb_belonging.list_id = :listId
            		ORDER BY tb_belonging.position     
            """)
    List<GameMinProjection> searchByList(Long listId);
}
