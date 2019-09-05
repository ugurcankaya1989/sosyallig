package com.football.sosyal.util;

import com.football.sosyal.model.Player;
import com.football.sosyal.model.dto.PlayerDTO;

import javax.persistence.Transient;

public class MapDtoToProxy {

    public static Player mapProxyToPlayer(Player player, PlayerDTO playerDTO){

        player.setId(playerDTO.getId());
        player.setName(playerDTO.getName());
        player.setHeight(playerDTO.getHeight());
        player.setPlayerPosition(playerDTO.getPlayerPosition());
        player.setBirthday(playerDTO.getBirthday());
        player.setContractStart(playerDTO.getContractStart());
        player.setContractEnd(playerDTO.getContractEnd());
        player.setfStartDate(playerDTO.getfStartDate());
        player.setTransferPayment(playerDTO.getTransferPayment());
        player.setTransferCommission(playerDTO.getTransferCommission());
        player.setContractPrice(playerDTO.getContractPrice());

        return player;
    }
}
