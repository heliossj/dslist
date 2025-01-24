package com.heliossj.dslist.repository;

import com.heliossj.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository <GameList, Long> {
}
