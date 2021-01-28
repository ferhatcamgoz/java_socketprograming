
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import java.util.Timer;
import java.util.TimerTask;
public class client{
	
  	static Socket serverSocket1;
  	
	       
    public static void main(String[] args) {
        
			try {
				serverSocket1 = new Socket("localhost", 1453);
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
       
		while(true)
		try {
			System.out.println(new DataInputStream(serverSocket1.getInputStream()).readUTF());
			
			} catch (IOException e) {
			e.printStackTrace();
			}	
		
		
	}











}


        
         

    

