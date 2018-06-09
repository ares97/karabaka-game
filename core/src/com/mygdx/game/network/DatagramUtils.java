package com.mygdx.game.network;

import com.mygdx.game.entity.Bullet;
import com.mygdx.game.entity.Tank;
import com.mygdx.game.game.EntityContainer;
import com.mygdx.game.utils.Direction;

import java.util.LinkedList;

public class DatagramUtils {

    public static String getDatagram() {
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

    public static void setEntitesFromDatagram(String datagram) {
        String[] entities = datagram.split(":");
        String[] tankPackage = entities[0].split("-");

        if (entities.length == 2) {
            String[] bulletPackage = entities[1].split("-");

            System.out.println(bulletPackage);
            LinkedList<Bullet> bullets = new LinkedList<>();
        }
        LinkedList<Tank> tanks = new LinkedList<>();

        for (int i = 0; i < tankPackage.length; i += 3) {
            tanks.add(new Tank(
                    Float.valueOf(tankPackage[i]),
                    Float.valueOf(tankPackage[i + 1]),
                    Direction.valueOf(tankPackage[i + 2])
            ));
        }
        for (Tank tank : tanks)
            System.out.println(tank);
    }
}
