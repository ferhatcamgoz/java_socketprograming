import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class server{

    public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	Random r = new Random();
        ServerSocket serverSocket;
        Socket clientSocket;
       DataOutputStream dataOutputStream;
        String mesaj;
        try {
            serverSocket = new ServerSocket(1450);
 	ArrayList<Socket> baglanlar= new ArrayList<>();
	System.out.println("Server başlatıldı");
 while(true) {
        	 clientSocket = serverSocket.accept();
        	baglanlar.add(clientSocket);

        	if(baglanlar.size()==2) {
System.out.println("Bağlantılar tamam");
        		break;
        	}
        	
        }
           


System.out.println("gönderme başlıyor");
Scanner scan4= new Scanner(System.in);
String sad= scan4.next();
while(true){

dataOutputStream = new DataOutputStream(baglanlar.get(r.nextInt(2)).getOutputStream());
int g = r.nextInt(100);

System.out.println("Üretilen sayı: "+g);
dataOutputStream.writeUTF("Server uretti->"+g);
try {
	
	Thread.sleep(500);
}
catch (Exception e) {
	// TODO: handle exception
}
/*          
for(Socket clientSockets : baglanlar) {
dataOutputStream = new DataOutputStream(clientSockets.getOutputStream());		                dataOutputStream.writeUTF(scan.next());
}*/
}
         
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }

}