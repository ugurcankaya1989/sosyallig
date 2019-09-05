package com.football.sosyal.controller;

import com.football.sosyal.model.Player;
import com.football.sosyal.model.Team;
import com.football.sosyal.model.dto.PlayerDTO;
import com.football.sosyal.model.dto.mapper.PlayerMapper;
import com.football.sosyal.service.PlayerService;
import com.football.sosyal.service.TeamService;
import com.football.sosyal.util.MapDtoToProxy;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/player")
public class PlayerController {

    private PlayerService playerService;
    private static final PlayerMapper mapper = Mappers.getMapper(PlayerMapper.class);
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    private TeamService teamService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> findPlayerById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(mapper.mapToDTO(playerService.findPlayerById(id)));

    }

    @GetMapping("/players")
    public ResponseEntity<List<PlayerDTO>> findAllPlayer(){
        List<PlayerDTO> playerDTOList = new ArrayList<>();
        List<Player> playerList = playerService.findAllPlayer();
        playerList.stream().forEach(player -> playerDTOList.add(mapper.mapToDTO(player)));
        return ResponseEntity.ok().body(playerDTOList);
    }

    @GetMapping("/playersByTeamId")
    public ResponseEntity<List<PlayerDTO>> getPlayersByTeam(@RequestParam("teamId") Long teamId){
        List<PlayerDTO> playerDTOList = new ArrayList<>();
        List<Player> playerList = playerService.findPlayerByTeamId(teamId);
        playerList.stream().forEach(player -> playerDTOList.add(mapper.mapToDTO(player)));
        return ResponseEntity.ok().body(playerDTOList);
    }

    @GetMapping
    public ResponseEntity<PlayerDTO> findPlayerByName(@RequestParam String name){
        return ResponseEntity.ok().body(mapper.mapToDTO(playerService.findPlayerByName(name)));
    }

    @PostMapping("/savePlayerByTeam")
    public ResponseEntity<PlayerDTO> addNewPlayer(@RequestBody PlayerDTO playerDTO){
        Team team;
        Player player = mapper.mapToEntity(playerDTO);

        if(playerDTO.getTeam() != null){
            team = teamService.findTeamByName(playerDTO.getTeam().getName());
            player.setTeam(team);
        }

        playerService.savePlayer(player);

        return ResponseEntity.ok().body(playerDTO);
    }

    @PostMapping("/savePlayers")
    public ResponseEntity<List<Player>> addPlayersByTeam(@PathVariable Long teamId, @RequestBody List<PlayerDTO> playerDTOList){
        Team team = teamService.findTeamById(teamId);
        List<Player> playerList = new ArrayList<>();
        playerDTOList.stream().forEach(playerDTO -> playerList.add(mapper.mapToEntity(playerDTO)));
        playerList.stream().forEach(player -> {
            player.setTeam(team);
            playerService.savePlayer(player);
        });

       return ResponseEntity.ok().body(playerList);
    }

    @PutMapping("/update")
    public ResponseEntity<PlayerDTO> updatePlayer(@RequestBody PlayerDTO playerDTO){
        Player player = playerService.findPlayerById(playerDTO.getId());
        player.setTeam(teamService.findTeamById(player.getTeam().getId()));
        player = MapDtoToProxy.mapProxyToPlayer(player,playerDTO);
        playerService.updatePlayer(player);
        return ResponseEntity.ok().body(playerDTO);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity removePlayer(@PathVariable Long id){
        playerService.removePlayerById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
