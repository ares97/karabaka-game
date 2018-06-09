package com.mygdx.game.handlers;

import com.mygdx.game.entity.Bullet;
import com.mygdx.game.entity.Tank;
import com.mygdx.game.game.EntityContainer;
import com.mygdx.game.utils.Direction;

import java.util.Timer;
import java.util.TimerTask;

public class ShootControllerOnClientSide implements ShootController {

    private final Tank tank;

    boolean canShoot = true;

    public ShootControllerOnClientSide(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void shot(Direction direction) {
        if (canShoot) {
            canShoot = false;
            EntityContainer.instance.addBullet(getBullet(direction));
            handleCooldown();
        }
    }

    private Bullet getBullet(Direction direction) {
        Bullet bullet = new Bullet();
        bullet.setDirection(direction);
        bullet.x = tank.x;
        bullet.y = tank.y;
        return bullet;
    }

    private void handleCooldown() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                canShoot = true;
            }
        }, 1000);
    }
}



