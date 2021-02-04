import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class r3{
    //client görevi
    static Socket serverSocket;
    static  DataInputStream dataInputStream;

    //server görevi
    static ServerSocket rserverSocket;
    static Socket client = new Socket();
    static Socket serverclient = new Socket();
    static String mesaj;
    static DataOutputStream dataOutputStream;




    public static void main(String[] args) throws UnknownHostException, IOException {
        BlockingQueue kuyruk = new ArrayBlockingQueue<>(10);
        //servere bağlanıyor
        serverSocket = new Socket("localhost", 1450);
        rserverSocket = new ServerSocket(1453);
//r3 bekleniyor
        serverclient = rserverSocket.accept();
        client = rserverSocket.accept();
        while(true){
            dataInputStream = new DataInputStream(serverSocket.getInputStream());

            mesaj = dataInputStream.readUTF();
            if(mesaj.equals("q")){
                dataOutputStream = new DataOutputStream(serverclient.getOutputStream());
                dataOutputStream.writeUTF(String.valueOf(new Random().nextInt(10)));
            }
            else {
                kuyruk.add(mesaj);
             

            try {
		
                dataOutputStream = new DataOutputStream(client.getOutputStream());
                dataOutputStream.writeUTF( kuyruk.poll()+"->r3 ");

            } catch (Exception e) {

                e.printStackTrace();
            }
            }
        }

    }

}