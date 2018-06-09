package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.utils.Direction;
import com.mygdx.game.utils.GameSettings;
import com.mygdx.game.utils.TankTextures;

public class Tank extends Rectangle {

    private Texture texture;

    private Direction direction;

    public Tank(float x, float y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.texture = getDirectedTexture();
    }

    public Texture getDirectedTexture() {
        switch (direction) {
            case UP:
                return TankTextures.instance.tankUp;
            case DOWN:
                return TankTextures.instance.tankDown;
            case LEFT:
                return TankTextures.instance.tankLeft;
            case RIGHT:
                return TankTextures.instance.tankRight;
            default:
                return TankTextures.instance.tankUp;
        }

    }

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
