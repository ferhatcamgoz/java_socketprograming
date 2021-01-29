




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


public class client{
	//client görevi
	static Socket serverSocket1; 
	static Socket serverSocket2; 
	static Socket serverSocket3;      
	


    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {

  //r1 bağlantı istediği 
 serverSocket1 = new Socket("localhost", 1451);
//r2 bağlantı isteği
serverSocket2 = new Socket("localhost", 1452);

//r3 bağlantı isteği
serverSocket3 = new Socket("localhost", 1453);



//r1 den gelen verileri kontrol ediyor
TimerTask task1 = new TimerTask() {
	
	@Override
	   public void run() {
		
		
		try {
			
				
				
				DataInputStream dataInputStream= new DataInputStream(serverSocket1.getInputStream());
				String mesaj=dataInputStream.readUTF();
				
				System.out.println(mesaj);
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
			
			
			
			DataInputStream dataInputStream= new DataInputStream(serverSocket2.getInputStream());
			String mesaj=dataInputStream.readUTF();
			
			System.out.println(mesaj);
			} catch (IOException e) {
			e.printStackTrace();
			}
	
	}
	
};

//r3 den gelen verileri kontrol ediyor
TimerTask task3 = new TimerTask() {
	
	@Override
	 public void run() {
	
		
		try {
			
			
			
			DataInputStream dataInputStream= new DataInputStream(serverSocket3.getInputStream());
			String mesaj=dataInputStream.readUTF();
			
			System.out.println(mesaj);
			} catch (IOException e) {
			e.printStackTrace();
			}
	
	}
	
};

Timer timer1 = new Timer();
	timer1.schedule(task1, 0,500);
	Timer timer2 = new Timer();
	timer2.schedule(task2, 0,500);
	Timer timer3 = new Timer();
	timer3.schedule(task3, 0,500);
              
        }
	

}


