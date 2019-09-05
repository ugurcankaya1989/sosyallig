package com.football.sosyal.controller;

import com.football.sosyal.model.Team;
import com.football.sosyal.model.dto.PlayerDTO;
import com.football.sosyal.model.dto.TeamDTO;
import com.football.sosyal.model.dto.mapper.TeamMapper;
import com.football.sosyal.service.TeamService;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/team")
public class TeamController {

    private TeamService teamService;

    private static final TeamMapper TEAM_MAPPER = Mappers.getMapper(TeamMapper.class);

    private static final Logger LOGGER = LoggerFactory.getLogger(TeamController.class);

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(TEAM_MAPPER.mapToDTO(teamService.findTeamById(id)));
    }

    @GetMapping
    public ResponseEntity<TeamDTO> findByName(@RequestParam String name){
        return ResponseEntity.ok().body(TEAM_MAPPER.mapToDTO(teamService.findTeamByName(name)));
    }

    @GetMapping("/teams")
    public ResponseEntity<List<TeamDTO>> findAllTeams(){
        List<Team> teamList = teamService.findAllTeam();
        List<TeamDTO> teamDTOList = new ArrayList<>();
        teamList.stream().forEach(team -> teamDTOList.add(TEAM_MAPPER.mapToDTO(team)));
        return ResponseEntity.ok().body(teamDTOList);
    }

    @PostMapping("/saveTeam")
    public ResponseEntity<TeamDTO> saveNewTeam(@RequestBody TeamDTO teamDTO){
        teamService.saveTeam(TEAM_MAPPER.mapToEntity(teamDTO));
        return ResponseEntity.ok().body(teamDTO);
    }

    @PostMapping("/saveTeams")
    public ResponseEntity<List<TeamDTO>> saveTeamsByLeague(@RequestBody List<TeamDTO> teamDTOList){
        for (TeamDTO teamDTO:teamDTOList) {
            teamService.saveTeam(TEAM_MAPPER.mapToEntity(teamDTO));
        }
        return ResponseEntity.ok().body(teamDTOList);
    }

    @PutMapping("/update")
    public ResponseEntity<TeamDTO> updateTeam(@RequestBody TeamDTO teamDTO){
        Team team = teamService.findTeamById(teamDTO.getId());
        if(team == null)
            throw new RuntimeException();
        team.setName(teamDTO.getName());
        team.setCurrencyCode(teamDTO.getCurrencyCode());
        teamService.updateTeam(team);
        return ResponseEntity.ok().body(TEAM_MAPPER.mapToDTO(team));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity removeTeam(@PathVariable Long id){
        teamService.removeTeamById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
