


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
       static  DataInputStream dataInputStream1;
       static  DataInputStream dataInputStream2;
	

	//server görevi
	static ServerSocket rserverSocket;	
	static Socket rclientSocket = new Socket();
	static String mesaj="";
	static DataOutputStream dataOutputStream;
	

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
Random r = new Random();
  //r1 bağlantı istediği 
 serverSocket1 = new Socket("localhost", 1451);
//r2 bağlantı isteği
serverSocket2 = new Socket("localhost", 1452);
//kendi server
 rserverSocket = new ServerSocket(1453);    
  


        ArrayList<Socket> baglanlar = new ArrayList<>();

        while(true) {
        	rclientSocket = rserverSocket.accept();
        	baglanlar.add(rclientSocket);
        	if(baglanlar.size()==2) {
        		break;
        	}
        	
        }


System.out.println("Görevler baslatiliyor");
TimerTask task1 = new TimerTask() {
	
	@Override
	   public void run() {
		
		
		try {
			
				//System.out.println("R1 MESAJ:"+new DataInputStream(serverSocket1.getInputStream()).readUTF());
				dataOutputStream = new DataOutputStream(baglanlar.get(r.nextInt(2)).getOutputStream());
				dataOutputStream.writeUTF(new DataInputStream(serverSocket1.getInputStream()).readUTF()+"->r3 ");
			} catch (IOException e) {
			e.printStackTrace();
			}	
		}
		
	
};

TimerTask task2 = new TimerTask() {
	
	@Override
	 public void run() {
	
		
		try {
				
				dataOutputStream = new DataOutputStream(baglanlar.get(r.nextInt(2)).getOutputStream());
				dataOutputStream.writeUTF(new DataInputStream(serverSocket2.getInputStream()).readUTF()+"->r3 ");								
	
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


