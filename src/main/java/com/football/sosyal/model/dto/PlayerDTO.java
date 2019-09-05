package com.football.sosyal.model.dto;

import com.football.sosyal.enums.PlayerPosition;

import java.time.LocalDate;

public class PlayerDTO extends IdBaseDTO {

    private String name;
    private LocalDate birthday;
    private Double height;
    private PlayerPosition playerPosition;
    private TeamDTO team;
    private LocalDate contractStart;
    private LocalDate contractEnd;
    private LocalDate fStartDate;
    private Long transferPayment;
    private Long transferCommission;
    private Long contractPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public PlayerPosition getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(PlayerPosition playerPosition) {
        this.playerPosition = playerPosition;
    }

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getContractStart() {
        return contractStart;
    }

    public void setContractStart(LocalDate contractStart) {
        this.contractStart = contractStart;
    }

    public LocalDate getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(LocalDate contractEnd) {
        this.contractEnd = contractEnd;
    }

    public LocalDate getfStartDate() {
        return fStartDate;
    }

    public void setfStartDate(LocalDate fStartDate) {
        this.fStartDate = fStartDate;
    }

    public Long getTransferPayment() {
        return transferPayment;
    }

    public void setTransferPayment(Long transferPayment) {
        this.transferPayment = transferPayment;
    }

    public Long getTransferCommission() {
        return transferCommission;
    }

    public void setTransferCommission(Long transferCommission) {
        this.transferCommission = transferCommission;
    }

    public Long getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(Long contractPrice) {
        this.contractPrice = contractPrice;
    }
}
