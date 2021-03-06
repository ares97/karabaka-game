package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.utils.TankTextures;
import com.mygdx.game.utils.Direction;
import com.mygdx.game.utils.GameSettings;

public class Bullet extends Rectangle {

    private Texture texture = TankTextures.instance.bullet;
    private Direction direction = Direction.UP;

    public Bullet() {
        texture = TankTextures.instance.bullet;
        direction = Direction.UP;
        x = 50;
        y = 50;
        width = 16;
        height = 16;
    }

    public Bullet(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void update() {
//        switch (direction) {
//            case RIGHT:
//                x += GameSettings.instance.BULLET_DISTANCE_PER_MOVE;
//                break;
//            case LEFT:
//                x -= GameSettings.instance.BULLET_DISTANCE_PER_MOVE;
//                break;
//            case DOWN:
//                y -= GameSettings.instance.BULLET_DISTANCE_PER_MOVE;
//                break;
//            case UP:
//                y += GameSettings.instance.BULLET_DISTANCE_PER_MOVE;
//                break;
//        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Texture getTexture() {
        return texture;
    }
}
