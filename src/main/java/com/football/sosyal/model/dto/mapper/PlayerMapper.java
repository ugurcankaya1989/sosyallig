package com.football.sosyal.model.dto.mapper;

import com.football.sosyal.model.Player;
import com.football.sosyal.model.dto.PlayerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper extends BaseMapper<PlayerDTO,Player>{
    Player mapToEntity(PlayerDTO playerDTO);

    PlayerDTO mapToDTO(Player player);
}
