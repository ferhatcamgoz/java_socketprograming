

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class r1{
    //client görevi
    static Socket serverSocket;
    static  DataInputStream dataInputStream;

    //server görevi
    static ServerSocket rserverSocket;
    static Socket client = new Socket();
    static Socket serverclient = new Socket();
    static String mesaj;
    static DataOutputStream dataOutputStream;
    static int randomtask=1000;

    public static void main(String[] args) throws UnknownHostException, IOException {
          BlockingQueue kuyruk = new ArrayBlockingQueue<>(10);
        // Queue<String> kuyruk = new LinkedList<String>();
        //servere bağlanıyor
        serverSocket = new Socket("localhost", 1450);
        rserverSocket = new ServerSocket(1451);
        //server bağlantı isteği bekliyor
        serverclient = rserverSocket.accept();
        //client bağlantı isteği bekliyor
        client = rserverSocket.accept();


        TimerTask task1 = new TimerTask() {

            @Override
            public void run() {
                try {
                    DataInputStream dataInputStream1 = new DataInputStream(serverSocket.getInputStream());
                     mesaj = dataInputStream1.readUTF();

                    System.out.println(mesaj);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (mesaj.equals("q")) {
                    try {
                        dataOutputStream = new DataOutputStream(serverclient.getOutputStream());
                        dataOutputStream.writeUTF(String.valueOf(kuyruk.size()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {

                    kuyruk.add(mesaj);


                }


            } };


        TimerTask task2 = new TimerTask() {

            @Override
            public void run() {

                if(!kuyruk.isEmpty()){

                    try {
                        dataOutputStream = new DataOutputStream(client.getOutputStream());
                        dataOutputStream.writeUTF( kuyruk.poll()+"->r1 ");

                        Thread.sleep(new Random().nextInt(5000));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }



            } };


        Timer timer1 = new Timer();
        timer1.schedule(task1, 0,500);

        Timer timer2 = new Timer();
        timer2.schedule(task2, 0,randomtask);










}}