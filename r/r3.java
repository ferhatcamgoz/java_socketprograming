

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;




public class r3{
	//client görevi
	static Socket serverSocket;      
       static  DataInputStream dataInputStream;

	//server görevi
	static ServerSocket rserverSocket;
	static Socket rclientSocket = new Socket();
	static String mesaj;
	static DataOutputStream dataOutputStream;

	
	

    public static void main(String[] args) throws UnknownHostException, IOException {

   //servere bağlanıyor
 serverSocket = new Socket("localhost", 1450);
 rserverSocket = new ServerSocket(1453);
//r3 bekleniyor      
rclientSocket = rserverSocket.accept();
while(true){		
	dataInputStream = new DataInputStream(serverSocket.getInputStream());
	
          mesaj = dataInputStream.readUTF();
       
		try {							
					
						dataOutputStream = new DataOutputStream(rclientSocket.getOutputStream());
						dataOutputStream.writeUTF( mesaj+"->r3 ");
	
						} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}               		                			
                			
                		}
                   
        } 

}


