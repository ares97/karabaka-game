package com.mygdx.game.game;

import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.entity.Bullet;
import com.mygdx.game.entity.Player;
import com.mygdx.game.entity.Tank;
import com.mygdx.game.network.DatagramSender;

import java.util.LinkedList;
import java.util.List;

public class EntityContainer implements Disposable {

    private List<Bullet> bullets;
    private List<Tank> tanks;
    private Player player;

    public final static EntityContainer instance = new EntityContainer();

    private EntityContainer() {
        bullets = new LinkedList<>();
        tanks = new LinkedList<>();
    }

    private Object bulletLock = new Object();
    private Object tankLock = new Object();

    public void addBullet(Bullet bullet) {
        synchronized (bulletLock) {
            bullets.add(bullet);
        }
    }

    public List<Bullet> getBullets() {
        synchronized (bulletLock) {
            return bullets;
        }
    }

    public void setBullets(List<Bullet> bullets) {
        synchronized (bulletLock) {
            this.bullets = bullets;
        }
    }

    public List<Tank> getTanks() {
        synchronized (tankLock) {
            return tanks;
        }
    }

    public void setTanks(List<Tank> tanks) {
        synchronized (tankLock) {
            this.tanks = tanks;
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void dispose() {
        for (Bullet bullet : getBullets()) {
            bullet.getTexture().dispose();
        }
        for (Tank tank : getTanks()) {
            tank.getTexture().dispose();
        }
    }
}
