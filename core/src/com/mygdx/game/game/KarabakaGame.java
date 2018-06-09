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
       // DatagramSender.instance.startSendingData();
       // DatagramReceiver.instance.startReceivingData();
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
        for (Bullet bullet : bullets) {
            bullet.update();
            for (Tank tank: tanks){
                if (bullet.overlaps(tank))
                    tank.x = -999;
            }
        }
    }

    private void renderObjects() {
        for (Tank tank : EntityContainer.instance.getTanks())
            batch.draw(tank.getTexture(), tank.x, tank.y);

        for (Bullet bullet : EntityContainer.instance.getBullets())
            batch.draw(bullet.getTexture(), bullet.x, bullet.y);
    }

    @Override
    public void dispose() {
        batch.dispose();
        EntityContainer.instance.dispose();
    }

    private void addTrashData() {
        tanks.add(new Tank(img, 300, 10));
        tanks.add(new Tank(img, 400, 200));

        Tank playerTank = new Tank(img, 200, 90);
        tanks.add(playerTank);
        player = new Player(playerTank);

        EntityContainer.instance.setBullets(bullets);
        EntityContainer.instance.setTanks(tanks);
        EntityContainer.instance.setPlayer(player);

    }
}
