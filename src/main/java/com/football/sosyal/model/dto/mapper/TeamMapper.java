package com.football.sosyal.model.dto.mapper;

import com.football.sosyal.model.Team;
import com.football.sosyal.model.dto.TeamDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper extends BaseMapper<TeamDTO,Team> {

    Team mapToEntity(TeamDTO teamDTO);

    TeamDTO mapToDTO(Team team);
}
