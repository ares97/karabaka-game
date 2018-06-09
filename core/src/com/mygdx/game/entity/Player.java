package com.mygdx.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.handlers.MoveController;
import com.mygdx.game.handlers.MovePlayerOnClientSide;
import com.mygdx.game.TankTextures;
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
            tank.setTexture(TankTextures.instance.tankLeft);
        } else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            moveController.moveTank(Direction.UP);
            tank.setTexture(TankTextures.instance.tankUp);
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            moveController.moveTank(Direction.DOWN);
            tank.setTexture(TankTextures.instance.tankDown);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            moveController.moveTank(Direction.RIGHT);
            tank.setTexture(TankTextures.instance.tankRight);
        }

    }

}
