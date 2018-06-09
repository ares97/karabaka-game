package com.mygdx.game.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DatagramReceiver {

    private DatagramSocket datagramSocket;


    public final static DatagramReceiver instance = new DatagramReceiver();

    public void startReceivingData(){
        Executors.newScheduledThreadPool(1)
                .scheduleWithFixedDelay(getRunnable(), 10, 1, TimeUnit.MILLISECONDS);
    }

    private Runnable getRunnable() {
        return () -> {
            byte[] buf = new byte[2048];
            DatagramPacket datagramPacket = new DatagramPacket(buf, 2048);
            try {
                datagramSocket.receive(datagramPacket);
                String datagram = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                DatagramUtils.parseDatagram(datagram);
                System.out.println(datagram);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }


    private DatagramReceiver() {
        try {
            datagramSocket = new DatagramSocket(DatagramSender.SERVER_RECEIVE_PORT);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
