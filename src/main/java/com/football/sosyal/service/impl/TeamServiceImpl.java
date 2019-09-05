package com.football.sosyal.service.impl;

import com.football.sosyal.model.Team;
import com.football.sosyal.repository.TeamRepository;
import com.football.sosyal.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    @Override
    public Team findTeamById(Long id) {
        return teamRepository.getOne(id);
    }

    @Override
    public List<Team> findAllTeam() {
        return teamRepository.findAll();
    }

    @Override
    public Team findTeamByName(String name) {
        return teamRepository.findByName(name);
    }

    @Override
    public void saveTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public void updateTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public void removeTeamById(Long id) {
        teamRepository.deleteById(id);
    }

}
