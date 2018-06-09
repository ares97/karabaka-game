package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.utils.Direction;
import com.mygdx.game.utils.GameSettings;

public class Tank extends Rectangle {

    private Texture texture;

    private Direction direction;

    public Tank(Texture texture) {
        this.texture = texture;
        direction = Direction.UP;
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

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}
