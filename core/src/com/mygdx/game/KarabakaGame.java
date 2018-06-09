package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.entity.Tank;

import java.util.LinkedList;
import java.util.List;

public class KarabakaGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture img;

    private List<Tank> tanks = new LinkedList<>();

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("core/assets/badlogic.jpg");
        tanks.add(new Tank(img, 10, 10));
        tanks.add(new Tank(img, 200, 200));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        renderTanks();
        batch.end();
    }

    private void renderTanks() {
        for (Tank tank : tanks)
            batch.draw(tank.getTexture(), tank.x, tank.y);
    }

    @Override
    public void dispose() {
        batch.dispose();
        for (Tank tank : tanks) {
            tank.getTexture().dispose();
        }
    }
}
