package com.mygdx.game.utils;

public class GameSettings {
    public final int WIDTH = 640;
    public final int HEIGHT = 480;

    public final int TANK_SIZE = 64;

    public final int BULLET_DISTANCE_PER_MOVE = 5;
    public final int DISTANCE_PER_MOVE = 3;

    public static GameSettings instance = new GameSettings();

    private GameSettings() {
    }
}
