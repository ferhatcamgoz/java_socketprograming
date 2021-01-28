




import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class r3{
	//client görevi
	static Socket serverSocket1; 
	static Socket serverSocket2;       
	static DataInputStream dataInputStream;
	

	//server görevi
	static ServerSocket rserverSocket;	
	static Socket rclientSocket = new Socket();
	
	static DataOutputStream dataOutputStream;
	

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {

  //r1 bağlantı istediği 
 serverSocket1 = new Socket("localhost", 1451);
//r2 bağlantı isteği
serverSocket2 = new Socket("localhost", 1452);
//kendi server
 rserverSocket = new ServerSocket(1453);
 //client bağlantı isteği bekliyor
  rclientSocket = rserverSocket.accept();

//r1 den gelen verileri kontrol ediyor
TimerTask task1 = new TimerTask() {
	
	@Override
	   public void run() {
		
		
		try {
			
				//cliente veri gönderme nesnesi hazırlanıyor
				dataOutputStream = new DataOutputStream(rclientSocket.getOutputStream());
				
				DataInputStream dataInputStream= new DataInputStream(serverSocket1.getInputStream());
				String mesaj=dataInputStream.readUTF();
				//veri gönderiyor
				dataOutputStream.writeUTF(mesaj+"->r3 ");
			} catch (IOException e) {
			e.printStackTrace();
			}	
		}
		
	
};
//r2 den gelen verileri kontrol ediyor
TimerTask task2 = new TimerTask() {
	
	@Override
	 public void run() {
	
		
		try {
			
			//cliente veri gönderme nesnesi hazırlanıyor
			dataOutputStream = new DataOutputStream(rclientSocket.getOutputStream());
			
			DataInputStream dataInputStream= new DataInputStream(serverSocket2.getInputStream());
			String mesaj=dataInputStream.readUTF();
			//veri gönderiyor
			dataOutputStream.writeUTF(mesaj+"->r3 ");
			} catch (IOException e) {
			e.printStackTrace();
			}
	
	}
	
};
Timer timer1 = new Timer();
	timer1.schedule(task1, 0,500);
	Timer timer2 = new Timer();
		timer2.schedule(task2, 0,500);
              
        }
	

}


