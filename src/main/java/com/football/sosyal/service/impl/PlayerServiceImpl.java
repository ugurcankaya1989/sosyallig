package com.football.sosyal.service.impl;

import com.football.sosyal.model.Player;
import com.football.sosyal.repository.PlayerRepository;
import com.football.sosyal.service.PlayerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player findPlayerById(Long id) {
        Player player = playerRepository.getOne(id);
        return setPlayerSalaryInfo(player);
    }

    @Override
    public Player findPlayerByName(String name) {
        Player player = playerRepository.findByName(name);
        return setPlayerSalaryInfo(player);
    }

    @Override
    public List<Player> findPlayerByTeamId(Long teamId) {
        List<Player> playerList = playerRepository.findPlayersByTeamId(teamId);
        playerList.stream().forEach(player -> setPlayerSalaryInfo(player));
        return playerList;
    }

    @Override
    public List<Player> findAllPlayer() {
        List<Player> playerList = playerRepository.findAll();
        playerList.stream().forEach(player -> setPlayerSalaryInfo(player));
        return playerList;
    }

    @Override
    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void updatePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void removePlayerById(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Player setPlayerSalaryInfo(Player player) {
        int age = Period.between(player.getBirthday(), LocalDate.now()).getYears();

        long monthsBetween = ChronoUnit.MONTHS.between(
                player.getContractStart().withDayOfMonth(1),
                player.getContractEnd());
        Long transferPayment = monthsBetween * 100000 / age;
        Long transferCommission = transferPayment * 10 / 100;

        Long contractPrice = transferPayment + transferCommission;

        player.setTransferPayment(transferPayment);
        player.setTransferCommission(transferCommission);
        player.setContractPrice(contractPrice);

        return player;
    }

}
