package com.mygdx.game.game;

import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.entity.Bullet;
import com.mygdx.game.entity.Player;
import com.mygdx.game.entity.Tank;

import java.awt.*;
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

    public void addBullet(Bullet bullet){
        bullets.add(bullet);
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(List<Bullet> bullets) {
        this.bullets = bullets;
    }

    public List<Tank> getTanks() {
        return tanks;
    }

    public void setTanks(List<Tank> tanks) {
        this.tanks = tanks;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void dispose() {
        for (Bullet bullet : bullets) {
            bullet.getTexture().dispose();
        }
        for (Tank tank : tanks) {
            tank.getTexture().dispose();
        }
    }
}
