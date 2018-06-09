package com.mygdx.game.network;

import com.mygdx.game.entity.Bullet;
import com.mygdx.game.entity.Tank;
import com.mygdx.game.game.EntityContainer;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;

public class DatagramReceiver {

    DatagramSocket datagramSocket;

    public final int SERVER_RECEIVE_PORT = 3111;


    public final static DatagramReceiver instance = new DatagramReceiver();

    private DatagramReceiver() {
        Runnable runnable = () -> {
            while (true) {
                try {
                    InetAddress ip = InetAddress.getByName("127.0.0.1");
                    datagramSocket = new DatagramSocket();
                    String string = "hello world!";
                    DatagramPacket datagramPacket =
                            new DatagramPacket(string.getBytes(), string.length(), ip, 3000);
                    datagramSocket.send(datagramPacket);
                    datagramSocket.close();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(runnable).start();

    }


}
