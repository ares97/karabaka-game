package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.utils.GameSettings;

public class Tank extends Rectangle {

    private final Texture texture;

    public Tank(Texture texture) {
        this.texture = texture;
        width = GameSettings.instance.TANK_SIZE;
        height = GameSettings.instance.TANK_SIZE;
    }

    public Tank(Texture texture, int x, int y) {
        this(texture);
        this.x = x;
        this.y = y;
    }

    public Texture getTexture() {
        return texture;
    }
}
