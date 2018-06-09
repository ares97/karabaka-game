package com.mygdx.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.MoveController;
import com.mygdx.game.MovePlayerOnClientSide;
import com.mygdx.game.utils.Direction;

public class Player {

    private Tank tank;

    private MoveController moveController;

    public Player(Tank tank) {
        this.tank = tank;
        moveController = new MovePlayerOnClientSide(tank);
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public void handlePlayerInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            moveController.moveTank((Direction.LEFT));
        } else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            moveController.moveTank(Direction.UP);
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            moveController.moveTank(Direction.DOWN);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            moveController.moveTank(Direction.RIGHT);
        }

    }

}
