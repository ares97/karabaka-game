package com.mygdx.game.network;

import com.mygdx.game.entity.Bullet;
import com.mygdx.game.entity.Tank;
import com.mygdx.game.game.EntityContainer;
import com.mygdx.game.utils.Direction;

import java.util.LinkedList;

public class DatagramUtils {

    public synchronized static String getDatagram() {
        //string = player[i].x + "\" + player[i].y + "\" + ... + ":" bullet[i].x + "\" + bullet[i].y + "\"
        String datagram = "";
        for (Tank player : EntityContainer.instance.getTanks()) {
            datagram += String.valueOf(player.x) + "-" + String.valueOf(player.y) + "-" +
                    String.valueOf(player.getDirection()) + "-";
        }
        datagram += ":";
        for (Bullet bullet : EntityContainer.instance.getBullets()) {
            datagram += String.valueOf(bullet.x) + "-" + String.valueOf(bullet.y) + "-";
        }
        System.out.println(datagram);
        return datagram;
    }

    public synchronized static void parseDatagram(String datagram) {
        String[] entities = datagram.split(":");

        if (entities.length >= 1) {
            String[] tankPackage = entities[0].split("-");
            decodeTankPackage(tankPackage);
        }
        if (entities.length == 2) {
            String[] bulletPackage = entities[1].split("-");
            decodeBulletPackage(bulletPackage);
        }
    }

    private static void decodeBulletPackage(String[] bulletPackage) {
        LinkedList<Bullet> bullets = new LinkedList<>();

        for (int i = 0; i < bulletPackage.length; i += 2) {
            bullets.add(new Bullet(
                    Float.valueOf(bulletPackage[i]),
                    Float.valueOf(bulletPackage[i + 1])
            ));
        }
        System.out.println(String.valueOf(bullets.size()));
        EntityContainer.instance.setBullets(bullets);
    }

    private static void decodeTankPackage(String[] tankPackage) {
        LinkedList<Tank> tanks = new LinkedList<>();
        for (int i = 0; i < tankPackage.length; i += 3) {
            tanks.add(new Tank(
                    Float.valueOf(tankPackage[i]),
                    Float.valueOf(tankPackage[i + 1]),
                    Direction.valueOf(tankPackage[i + 2])
            ));
        }
        System.out.println(tanks.size());
        EntityContainer.instance.setTanks(tanks);
    }
}
