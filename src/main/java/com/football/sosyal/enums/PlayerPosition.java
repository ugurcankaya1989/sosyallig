package com.football.sosyal.enums;

public enum PlayerPosition {

    GOALKEEPER(1),
    CENTREBACK(2),
    LEFTBACK(3),
    RIGHTBACK(4),
    DEFENSIVEMIDFIELD(5),
    CENTRALMIDFIELD(6),
    ATTACKINGMIDFIELD(7),
    LEFTWINGER(8),
    RIGHTWINGER(9),
    CENTREFORWARD(10);

    private final int playerPosition;

    PlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }
}
