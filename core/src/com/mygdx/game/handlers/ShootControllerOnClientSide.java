package com.mygdx.game.handlers;

import com.mygdx.game.entity.Bullet;
import com.mygdx.game.entity.Tank;
import com.mygdx.game.game.EntityContainer;
import com.mygdx.game.utils.Direction;
import com.mygdx.game.utils.GameSettings;

import java.util.Timer;
import java.util.TimerTask;

public class ShootControllerOnClientSide implements ShootController {

    private final Tank tank;

    Bullet bullet;

    boolean canShoot = true;

    public ShootControllerOnClientSide(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void shot(Direction direction) {
        if (canShoot) {
            canShoot = false;
            bullet = getBullet(direction);
            EntityContainer.instance.addBullet(bullet);
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



