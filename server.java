


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class server{

    public static void main(String[] args) throws InterruptedException, IOException {
	
	Random r = new Random();
        ServerSocket serverSocket;
        Socket clientSocket;
        DataOutputStream dataOutputStream;    
        serverSocket = new ServerSocket(1450);
	ArrayList<Socket> baglanlar= new ArrayList<>();
//r1 ve r2 bağlantılarını kabul ediyor
 while(true) {
        	 clientSocket = serverSocket.accept();
        	baglanlar.add(clientSocket);

        	if(baglanlar.size()==2) {
System.out.println("Bağlantılar tamam");
        		break;
        	}   	
        }
Scanner scan4= new Scanner(System.in);
String tetik= scan4.next();
while(true){
//r1 veya r2'den birine rastegele veri gönderimine hazırlanıyor
dataOutputStream = new DataOutputStream(baglanlar.get(r.nextInt(2)).getOutputStream());
int g = r.nextInt(100);
System.out.println("uretilen sayi:"+g);
//gönderiliyor
dataOutputStream.writeUTF(g+": s->");
//500 milisaniye bekliyor
	Thread.sleep(r.nextInt(5000));



}
         
        }

    }

