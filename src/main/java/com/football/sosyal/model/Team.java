package com.football.sosyal.model;

import com.football.sosyal.enums.CurrencyCode;
import com.football.sosyal.model.base.IdBaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TEAM")
public class Team extends IdBaseEntity {

    @Column(name = "team_name")
    private String name;

    @Column(name = "currency_code")
    @Enumerated(EnumType.STRING)
    private CurrencyCode currencyCode;

    @Column
    private String league;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Player> playerList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
