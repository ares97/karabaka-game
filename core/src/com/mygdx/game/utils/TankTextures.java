package com.mygdx.game.utils;

import com.badlogic.gdx.graphics.Texture;

public class TankTextures {

    public final Texture tankUp;
    public final Texture tankDown;
    public final Texture tankLeft;
    public final Texture tankRight;

    public final Texture bullet;

    public static TankTextures instance = new TankTextures();

    private TankTextures() {
        tankUp = new Texture("core/assets/Tank_up.png");
        tankDown = new Texture("core/assets/Tank_down.png");
        tankLeft = new Texture("core/assets/Tank_left.png");
        tankRight = new Texture("core/assets/Tank_right.png");

        bullet = new Texture("core/assets/bullet.png");
    }
}
