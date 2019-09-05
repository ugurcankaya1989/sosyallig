package com.football.sosyal.model;

import com.football.sosyal.enums.PlayerPosition;
import com.football.sosyal.model.base.IdBaseEntity;
import com.football.sosyal.model.dto.PlayerDTO;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PLAYER")
public class Player extends IdBaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "height")
    private Double height;

    @Column(name = "player_position")
    @Enumerated(EnumType.STRING)
    private PlayerPosition playerPosition;

    @ManyToOne(fetch = FetchType.EAGER)
    private Team team;

    @Column(name = "contract_start")
    private LocalDate contractStart;

    @Column(name = "contract_end")
    private LocalDate contractEnd;

    @Column(name = "fStartDate")
    private LocalDate fStartDate;

    @Transient()
    private Long transferPayment;

    @Transient
    private Long transferCommission;

    @Transient
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
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
