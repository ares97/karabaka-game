package com.mygdx.game.handlers;

import com.mygdx.game.entity.Tank;
import com.mygdx.game.utils.Direction;

public class ShootControllerOnClientSide implements ShootController {

    private final Tank tank;

    public ShootControllerOnClientSide(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void shot(Direction direction) {

    }
}
