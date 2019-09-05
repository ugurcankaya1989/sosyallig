package com.football.sosyal.model.dto;

import com.football.sosyal.enums.CurrencyCode;

public class TeamDTO extends IdBaseDTO {

    private String name;
    private CurrencyCode currencyCode;
    private String league;

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
}
