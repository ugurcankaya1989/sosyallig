package com.football.sosyal.repository;

import com.football.sosyal.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
    Player findByName(String name);

    List<Player> findPlayersByTeamId(Long teamId);
}
