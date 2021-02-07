import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class server{
    static Socket r1;
    static Socket r2;
    static Socket r3;
    static DataInputStream dataInputStream;

    public static void main(String[] args) throws InterruptedException, IOException {

        Random r = new Random();
        ServerSocket serverSocket;
        Socket clientSocket;
        DataOutputStream dataOutputStream;
        serverSocket = new ServerSocket(1450);

        ArrayList<Socket> baglanlar= new ArrayList<>();
//r1, r2 ve r3 bağlantılarını kabul ediyor
        while(true) {
            clientSocket = serverSocket.accept();
            baglanlar.add(clientSocket);

            if(baglanlar.size()==3) {
                System.out.println("Bağlantılar tamam");
                break;
            }
        }
//r1, r2 ve r3 bağlantı isteği gönderiyor
        r1 = new Socket("localhost", 1451);
        r2 = new Socket("localhost", 1452);
        r3 = new Socket("localhost", 1453);
        Scanner scan4= new Scanner(System.in);
        String tetik= scan4.next();

        while(true){
            String q1;
            String q2;
            String q3;
            dataOutputStream = new DataOutputStream(baglanlar.get(0).getOutputStream());

            dataOutputStream.writeUTF("q");

            dataInputStream = new DataInputStream(r1.getInputStream());

            q1 = dataInputStream.readUTF();


            dataOutputStream = new DataOutputStream(baglanlar.get(1).getOutputStream());

            dataOutputStream.writeUTF("q");

            dataInputStream = new DataInputStream(r2.getInputStream());

            q2 = dataInputStream.readUTF();


            dataOutputStream = new DataOutputStream(baglanlar.get(2).getOutputStream());

            dataOutputStream.writeUTF("q");

            dataInputStream = new DataInputStream(r3.getInputStream());

            q3 = dataInputStream.readUTF();

int dizi[] = new int[3];
dizi[0]=Integer.parseInt(q1);
dizi[1]=Integer.parseInt(q2);
dizi[2]=Integer.parseInt(q3);
int min=dizi[0];
int k=0;

            for(int i=1; i<dizi.length; i++) {

                if (min > dizi[i]) {

                    min = dizi[i];
                    k = i;

                }
            }


            dataOutputStream = new DataOutputStream(baglanlar.get(k).getOutputStream());
            int g = r.nextInt(100);
            System.out.println("uretilen sayi:"+g);
//gönderiliyor
            dataOutputStream.writeUTF(g+": s->");
//5000 milisaniye bekliyor
            Thread.sleep(r.nextInt(5000));



        }

    }

}

