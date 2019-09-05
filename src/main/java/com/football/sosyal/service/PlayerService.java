package com.football.sosyal.service;


import com.football.sosyal.model.Player;

import java.util.List;

public interface PlayerService  {
    Player findPlayerById(Long id);
    Player findPlayerByName(String name);
    List<Player> findPlayerByTeamId(Long teamId);
    List<Player> findAllPlayer();
    void savePlayer(Player player);
    void updatePlayer(Player player);
    void removePlayerById(Long id);
    Player setPlayerSalaryInfo(Player player);
}
