package com.football.sosyal.service;


import com.football.sosyal.model.Team;

import java.util.List;

public interface TeamService {

    Team findTeamById(Long id);
    List<Team> findAllTeam();
    Team findTeamByName(String name);
    void saveTeam(Team team);
    void updateTeam(Team team);
    void removeTeamById(Long id);
}
