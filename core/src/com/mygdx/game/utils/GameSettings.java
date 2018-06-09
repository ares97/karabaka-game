package com.mygdx.game.utils;

public class GameSettings {
    public final int WIDTH = 640;
    public final int HEIGHT = 480;

    public final int TANK_SIZE = 1;

    public final int DISTANCE_PER_MOVE = 5;

    public static GameSettings instance = new GameSettings();

    private GameSettings() {
    }
}
