package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class TankTextures {

    public final Texture tankUp;
    public final Texture tankDown;
    public final Texture tankLeft;
    public final Texture tankRight;

    public static TankTextures instance = new TankTextures();

    private TankTextures() {
        this.tankUp = new Texture("core/assets/Tank_up.png");
        this.tankDown = new Texture("core/assets/Tank_down.png");
        this.tankLeft = new Texture("core/assets/Tank_left.png");
        this.tankRight = new Texture("core/assets/Tank_right.png");
    }
}
