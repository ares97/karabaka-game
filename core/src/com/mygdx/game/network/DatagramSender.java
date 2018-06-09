package com.mygdx.game.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DatagramSender {

    DatagramSocket datagramSocket;

    public final int SERVER_RECEIVE_PORT = 3111;

    public final static DatagramSender instance = new DatagramSender();


    public void startSendingData() {
        Executors.newScheduledThreadPool(2)
                .scheduleWithFixedDelay(getRunnable(), 10, 5, TimeUnit.MILLISECONDS);
    }

    private DatagramSender() {
        try {
            datagramSocket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private Runnable getRunnable() {
        return () -> {
                try {
                    InetAddress ip = InetAddress.getByName("127.0.0.1");

                    String mssg = DatagramUtils.getDatagram();
                    DatagramPacket datagramPacket =
                            new DatagramPacket(mssg.getBytes(), mssg.length(), ip, 3000);
                    datagramSocket.send(datagramPacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        };
    }


}
