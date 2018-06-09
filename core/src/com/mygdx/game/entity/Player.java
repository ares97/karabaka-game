package com.mygdx.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.handlers.MoveController;
import com.mygdx.game.handlers.MovePlayerOnClientSide;
import com.mygdx.game.handlers.ShootController;
import com.mygdx.game.handlers.ShootControllerOnClientSide;
import com.mygdx.game.utils.TankTextures;
import com.mygdx.game.utils.Direction;

public class Player {

    private Tank tank;

    private MoveController moveController;

    private ShootController shootController;

    public Player(Tank tank) {
        this.tank = tank;
        moveController = new MovePlayerOnClientSide(tank);
        shootController = new ShootControllerOnClientSide(tank);
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public void handlePlayerInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            tank.setDirection(Direction.LEFT);
            moveController.moveTank((Direction.LEFT));
            tank.setTexture(TankTextures.instance.tankLeft);
        } else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            tank.setDirection(Direction.UP);
            moveController.moveTank(Direction.UP);
            tank.setTexture(TankTextures.instance.tankUp);
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            tank.setDirection(Direction.DOWN);
            moveController.moveTank(Direction.DOWN);
            tank.setTexture(TankTextures.instance.tankDown);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            tank.setDirection(Direction.RIGHT);
            moveController.moveTank(Direction.RIGHT);
            tank.setTexture(TankTextures.instance.tankRight);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            shootController.shot(tank.getDirection());
        }
    }

}
