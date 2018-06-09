package com.mygdx.game.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.entity.Bullet;
import com.mygdx.game.entity.Player;
import com.mygdx.game.entity.Tank;
import com.mygdx.game.utils.TankTextures;

import java.util.LinkedList;
import java.util.List;

public class KarabakaGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture img;

    private Player player;
    private List<Tank> tanks = new LinkedList<>();
    private List<Bullet> bullets = new LinkedList<>();

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = TankTextures.instance.tankUp;

        addTrashData();

        Tank playerTank = new Tank(img, 60, 90);
        tanks.add(playerTank);
        player = new Player(playerTank);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        renderObjects();

        batch.end();

        update();
    }

    private void update() {
        player.handlePlayerInput();
        for (Bullet bullet : bullets)
            bullet.update();
    }

    private void renderObjects() {
        for (Tank tank : tanks)
            batch.draw(tank.getTexture(), tank.x, tank.y);

        for (Bullet bullet : bullets)
            batch.draw(bullet.getTexture(), bullet.x, bullet.y);
    }

    @Override
    public void dispose() {
        batch.dispose();
        for (Tank tank : tanks) {
            tank.getTexture().dispose();
        }
    }

    private void addTrashData() {
        tanks.add(new Tank(img, 10, 10));
        tanks.add(new Tank(img, 200, 200));

        bullets.add(new Bullet());
        bullets.add(new Bullet());

        EntityContainer.instance.setBullets(bullets);
        EntityContainer.instance.setTanks(tanks);
        EntityContainer.instance.setPlayer(player);

    }
}
