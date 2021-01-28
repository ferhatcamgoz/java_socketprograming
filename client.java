
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import java.util.Timer;
import java.util.TimerTask;
public class client{
	static int b=0;
	static int c =0;
	static String input1 =null;
	static String input2 = null;

  	static Socket serverSocket1;
  static	Socket    serverSocket2;
	static DataInputStream dataInputStream;       
    public static void main(String[] args) {
        
			try {
				serverSocket1 = new Socket("localhost", 1454);
				serverSocket2= new Socket("localhost", 1455);
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	  	 

     
		
	
		

  String mesaj="";          




Timer timer = new Timer();
TimerTask task1 = new TimerTask() {
	
	@Override
	public void run() {
		
		
		try {
			System.out.println("R1 MESAJ:"+new DataInputStream	(serverSocket1.getInputStream()).readUTF());
			
			} catch (IOException e) {
			e.printStackTrace();
			}	
		}
		
	
};
Timer timer2 = new Timer();
TimerTask task2 = new TimerTask() {
	
	@Override
	public void run() {
		
		
		try {
			System.out.println("R2 MESAJ:"+new DataInputStream	(serverSocket2.getInputStream()).readUTF());
			
			} catch (IOException e) {
			e.printStackTrace();
			}	
		}
		
	
};

	timer.schedule(task1, 0,500);
	timer2.schedule(task2, 0,500);
	







}}
        
         

    

