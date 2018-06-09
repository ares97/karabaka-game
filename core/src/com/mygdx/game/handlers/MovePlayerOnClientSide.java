package com.mygdx.game.handlers;

import com.mygdx.game.entity.Tank;
import com.mygdx.game.utils.Direction;
import com.mygdx.game.utils.GameSettings;

public class MovePlayerOnClientSide implements MoveController {

    private final Tank tank;

    public MovePlayerOnClientSide(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void moveTank(Direction direction) {
        switch (direction) {
            case UP:
                tank.y += GameSettings.instance.DISTANCE_PER_MOVE;
                break;
            case DOWN:
                tank.y -= GameSettings.instance.DISTANCE_PER_MOVE;
                break;
            case LEFT:
                tank.x -= GameSettings.instance.DISTANCE_PER_MOVE;
                break;
            case RIGHT:
                tank.x += GameSettings.instance.DISTANCE_PER_MOVE;
                break;
        }
    }
}
